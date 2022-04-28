package com.FoodBox.controller;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.FoodBox.DTO.OrderDetail;
import com.FoodBox.model.Cart;
import com.FoodBox.model.Cuisines;
import com.FoodBox.service.CartService;
import com.FoodBox.service.CuisinesService;
import com.FoodBox.service.PaypalService;
import com.FoodBox.service.UserService;
import com.FoodBox.controller.UserWebController;
import com.paypal.api.payments.Links;
import com.paypal.api.payments.Payment;
import com.paypal.base.rest.PayPalRESTException;

@Controller
public class PaypalController {

    @Autowired
    PaypalService service;
    
    @Autowired
    CartService cartService;

    @Autowired
    UserService userService;
    
    @Autowired
    CuisinesService cuisineService;
    
    public static final String SUCCESS_URL = "pay/success";
    public static final String CANCEL_URL = "pay/cancel";

    @GetMapping("/pay_details")
    public String getPaymentDetails(Model model) {
    	
    	if(UserWebController.username==null) {
    		return "redirect:/login";
    	}
    	
    	
    	List<Cart> carts = cartService.getCarts();
    	
    	if(carts.size()==0) {
    		return "redirect:/view_cart";
    	}
    	
    	List<Cuisines> foodInfo = cuisineService.getAllCuisines();
    	
    	OrderDetail orderDetails = new OrderDetail();
    	
    	orderDetails.setPrice(cartService.totalCartPrice());
    	
    	model.addAttribute("foodInfo", foodInfo);
    	
    	model.addAttribute("carts", carts);
    	
    	model.addAttribute("cartService", cartService);
    	
    	model.addAttribute("order", orderDetails);
    	
    	return "pay_details";
    }
    
    @PostMapping("/pay")
    public String payment(@ModelAttribute("order") OrderDetail order) {
        try {
            Payment payment = service.createPayment(order.getPrice(), order.getCurrency(), order.getMethod(),
                    order.getIntent(), order.getDescription(), "http://localhost:8080/" + CANCEL_URL,
                    "http://localhost:8080/" + SUCCESS_URL);
            for(Links link:payment.getLinks()) {
                if(link.getRel().equals("approval_url")) {
                    return "redirect:"+link.getHref();
                }
            }

        } catch (PayPalRESTException e) {

            e.printStackTrace();
        }
        return "redirect:/";
    }

     @GetMapping(value = CANCEL_URL)
        public String cancelPay() {
            return "cancel";
        }

        @GetMapping(value = SUCCESS_URL)
        public String successPay(@RequestParam("paymentId") String paymentId, @RequestParam("PayerID") String payerId, Model model) {
            try {
                Payment payment = service.executePayment(paymentId, payerId);
                System.out.println(payment.toJSON());
                if (payment.getState().equals("approved")) {
                	model.addAttribute("orderNum");
                	String username = UserWebController.username;
                	int orderNum = cartService.cartToPast(cartService.getCarts(), userService.getUserByUsername(username).getUserId());
                	model.addAttribute("orderNum", orderNum);
                	cartService.emptyCart();
                    return "success";
                }
            } catch (PayPalRESTException e) {
             System.out.println(e.getMessage());
            }
            return "redirect:/";
        }

}