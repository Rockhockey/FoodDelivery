package com.FoodBox.controller;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.FoodBox.model.Cart;
import com.FoodBox.model.Cuisines;
import com.FoodBox.service.CartService;
import com.FoodBox.service.CuisinesService;
import com.FoodBox.FoodBoxApplication;

@Controller
public class CartWebController {
	
	@Autowired
	private CartService cartService;
	
	@Autowired
	private CuisinesService cuisineService;
	
	@GetMapping("/add_to_cart/{cId}")
	public String addToCart(@PathVariable(name="cId") Integer Id, Model model) {
		
		model.addAttribute("cuisines", cuisineService.getCuisineById(Id));
		
		return "new_cart_item";
	}
	
	@PostMapping(value = "/save_to_cart")
	public String saveToCart(@ModelAttribute("cuisines") Cuisines cuisine, @RequestParam("quantity") Integer quantity, BindingResult bindingResult) throws IOException {
		
		List<Cart> allCart = cartService.getCarts();
		
		for(int i = 0; i < allCart.size(); i++) {
			
			Cart iterator = allCart.get(i);
			
			if(iterator.getItem()==cuisine.getId()) {
				iterator.setQuantity(quantity + iterator.getQuantity());
				cartService.saveCart(iterator);
				return "redirect:/view/all/none/default";
			}
		}
		
		Cart cart = new Cart();
		cart.setItem(cuisine.getId());
		cart.setQuantity(quantity);
		
		cartService.saveCart(cart);
		
		return "redirect:/view/all/none/default";
	}
	
	@GetMapping("/view_cart")
	public String cartView(Model model) {
		
		List<Cart> cartList = cartService.getCarts();
		
		List<Cuisines> cuisinesList = cuisineService.getAllCuisines();
		
		model.addAttribute("carts", cartList);
		
		model.addAttribute("cuisines", cuisinesList);
		
		return "cart_view";
	}
	
	
	@GetMapping("/update_quantity/{cartId}")
	public String updateQuantity(@PathVariable(name = "cartId") Integer cartId, Model model) {
		
		Cart cart = cartService.getCart(cartId);
		
		model.addAttribute("cuisines", cuisineService.getCuisineById(cart.getItem()));
		
		model.addAttribute("cart", cart);
		
		return "update_quantity";
	}
	
	
	
	@PostMapping(value = "/save_quantity")
	public String saveQuantity(@ModelAttribute("cart") Cart cart) throws IOException {
		
		cartService.saveCart(cart);
		
		return "redirect:/view_cart";
	}
	
	@GetMapping("/delete_from_cart/{cartId}")
	public String deleteFromCart(@PathVariable(name = "cartId") Integer cartId, Model model) {
		
		Cart cart = cartService.getCart(cartId);
		
		model.addAttribute("cuisines", cuisineService.getCuisineById(cart.getItem()));
		
		model.addAttribute("cart", cart);
		
		
		return "cart_delete";
	}
	
	@PostMapping(value = "/save_delete_cart")
	public String saveDeleteCart(@ModelAttribute("cart") Cart cart) throws IOException {
		
		cartService.deleteCart(cart.getCartIndex());
		
		return "redirect:/view_cart";
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}