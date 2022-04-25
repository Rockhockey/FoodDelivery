package com.FoodBox.controller;

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
    CuisinesService cuisineService;
    
    public static final String SUCCESS_URL = "pay/success";
    public static final String CANCEL_URL = "pay/cancel";

    @GetMapping("/pay_details")
    public String getPaymentDetails(Model model) {
    	
    	double finalPrice = 0;
    	Cuisines cuisine;
    	
    	OrderDetail orderDetails = new OrderDetail();
    	
    	List<Cart> cart = cartService.getCarts();
    	
    	for(int i = 0; i < cart.size(); i++) {
    		cuisine = cuisineService.getCuisineById(cart.get(i).getItem());
    		finalPrice += (cuisine.getPrice()*cuisine.getOffer()*(cart.get(i).getQuantity()));
    	}
    	
    	model.addAttribute("total_price", finalPrice);
    	
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
        public String successPay(@RequestParam("paymentId") String paymentId, @RequestParam("PayerID") String payerId) {
            try {
                Payment payment = service.executePayment(paymentId, payerId);
                System.out.println(payment.toJSON());
                if (payment.getState().equals("approved")) {
                    return "success";
                }
            } catch (PayPalRESTException e) {
             System.out.println(e.getMessage());
            }
            return "redirect:/";
        }

}