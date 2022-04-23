package com.FoodBox.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.tomcat.util.http.fileupload.FileUpload;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.FoodBox.FileUpload.FileUploadUtil;
import com.FoodBox.model.Cuisines;
import com.FoodBox.model.Users;

@Controller
public class CuisineWebController {
	
	@Autowired
	CuisineController cuisineController;
	
	@Autowired
	UserController userController;
	
	@GetMapping("/admin")
	public String getAllCuisines(Model model) {
		
		List<Cuisines> cuisinesList = cuisineController.getAllCuisines();
		
		model.addAttribute("cuisines", cuisinesList);
		
		if(UserWebController.username!=null) {
			Users user = userController.getUser(UserWebController.username);
			if(user.getIsAdmin())
				return "list_cuisines";
		}
		
		return "redirect:/";
	}
	
	@GetMapping("/view")
	public String userView(Model model) {
		
		List<Cuisines> cuisinesList = cuisineController.getAllCuisines();
		
		model.addAttribute("cuisines", cuisinesList);
		
		Boolean admin = null;
		
		if(UserWebController.username!=null) {
			Users user = userController.getUser(UserWebController.username);
			admin = user.getIsAdmin();
		}
		model.addAttribute("admin", admin);
		
		return "view";
	}
	
	@GetMapping("/view/indian")
	public String userIndianView(Model model) {
		
		List<Cuisines> cuisinesList = cuisineController.getAllCuisines();
		
		List<Cuisines> indianCuisinesList = new ArrayList<Cuisines>();
		
		for(int i=0;i<cuisinesList.size();i++) {
			if(cuisinesList.get(i).getCuisineType().equals("Indian")) {
				indianCuisinesList.add(cuisinesList.get(i));
			}
		}
		
		model.addAttribute("cuisines", indianCuisinesList);
		
		Boolean admin = null;
		
		if(UserWebController.username!=null) {
			Users user = userController.getUser(UserWebController.username);
			admin = user.getIsAdmin();
		}
		model.addAttribute("admin", admin);
		
		return "view";
	}
	
	@GetMapping("/view/chinese")
	public String userChineseView(Model model) {
		
		List<Cuisines> cuisinesList = cuisineController.getAllCuisines();
		
		List<Cuisines> chineseCuisinesList = new ArrayList<Cuisines>();
		
		for(int i=0;i<cuisinesList.size();i++) {
			if(cuisinesList.get(i).getCuisineType().equals("Chinese")) {
				chineseCuisinesList.add(cuisinesList.get(i));
			}
		}
		
		model.addAttribute("cuisines", chineseCuisinesList);
		
		Boolean admin = null;
		
		if(UserWebController.username!=null) {
			Users user = userController.getUser(UserWebController.username);
			admin = user.getIsAdmin();
		}
		model.addAttribute("admin", admin);
		
		return "view";
	}
	
	@GetMapping("/view/italian")
	public String userItalianView(Model model) {
		
		List<Cuisines> cuisinesList = cuisineController.getAllCuisines();
		
		List<Cuisines> italianCuisinesList = new ArrayList<Cuisines>();
		
		for(int i=0;i<cuisinesList.size();i++) {
			if(cuisinesList.get(i).getCuisineType().equals("Italian")) {
				italianCuisinesList.add(cuisinesList.get(i));
			}
		}
		
		model.addAttribute("cuisines", italianCuisinesList);
		
		Boolean admin = null;
		
		if(UserWebController.username!=null) {
			Users user = userController.getUser(UserWebController.username);
			admin = user.getIsAdmin();
		}
		model.addAttribute("admin", admin);
		return "view";
	}
	
	@GetMapping("/view/mexican")
	public String userMexicanView(Model model) {
		
		List<Cuisines> cuisinesList = cuisineController.getAllCuisines();
		
		List<Cuisines> mexicanCuisinesList = new ArrayList<Cuisines>();
		
		for(int i=0;i<cuisinesList.size();i++) {
			if(cuisinesList.get(i).getCuisineType().equals("Mexican")) {
				mexicanCuisinesList.add(cuisinesList.get(i));
			}
		}
		
		model.addAttribute("cuisines", mexicanCuisinesList);
		
		Boolean admin = null;
		
		if(UserWebController.username!=null) {
			Users user = userController.getUser(UserWebController.username);
			admin = user.getIsAdmin();
		}
		model.addAttribute("admin", admin);
		return "view";
	}
	
	@GetMapping("/new_item")
	public String addItem(Model model) {
		
		Cuisines cuisine = new Cuisines();
		
		model.addAttribute("cuisines", cuisine);
		
		return "new_item";
		
	}
	
	@PostMapping(value = "/save_new")
	public String saveNewItem(@ModelAttribute("cuisines") Cuisines cuisine, @RequestParam("image") MultipartFile multipartFile) throws IOException {
		
		String uploadDir = "src/main/resources/static/images/";
		
		String savedFileName = ("/images/" + StringUtils.cleanPath(multipartFile.getOriginalFilename()));
		
		String fileName = StringUtils.cleanPath(multipartFile.getOriginalFilename());
		
		cuisine.setPicture(savedFileName);
		
		cuisineController.saveCuisines(cuisine);
		
		FileUploadUtil.saveFile(uploadDir, fileName, multipartFile);
		
		return "redirect:/admin";
		
	}
	
	@GetMapping("/update_item/{cId}")
	public String editItem(@PathVariable(name = "cId") Integer Id, Model model) {
		
		model.addAttribute("cuisines", cuisineController.getCuisineById(Id));
		
		return "update_item";
		
	}
	
	@PostMapping(value = "/save_update")
	public String saveUpdateItem(@ModelAttribute("cuisines") Cuisines cuisine) {
		
		cuisineController.updateCuisine(cuisine.getId(), cuisine);
		
		return "redirect:/admin";
	}
	
	@GetMapping("/delete_item/{cId}")
	public String deleteItem(@PathVariable(name = "cId") Integer Id, Model model) {
		
		model.addAttribute("cuisines", cuisineController.getCuisineById(Id));
		
		return "delete_item";
		
	}
	
	@PostMapping(value = "/save_delete")
	public String saveDeleteItem(@ModelAttribute("cuisines") Cuisines cuisine) {
		
		cuisineController.deleteCuisine(cuisine.getId());
		
		return "redirect:/admin";
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}