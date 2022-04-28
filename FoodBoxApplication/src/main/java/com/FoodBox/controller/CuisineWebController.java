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
import com.FoodBox.service.CuisinesService;
import com.FoodBox.service.UserService;

@Controller
public class CuisineWebController {
	

	@Autowired
	private CuisinesService cuisineService;
	
	@Autowired
	private UserService userService;
	
	@GetMapping("/admin")
	public String getAllCuisines(Model model) {
		
		List<Cuisines> cuisinesList = cuisineService.getAllCuisines();
		
		model.addAttribute("cuisines", cuisinesList);
		
		if(UserWebController.username!=null) {
			Users user = userService.getUserByUsername(UserWebController.username);
			if(user.getIsAdmin())
				return "list_cuisines";
		}
		
		return "redirect:/";
	}
	
	@PostMapping(value = "/search")
	public String search(@RequestParam String search) {
		
		return ("redirect:/view/all/none/" + search);
	}
	
	@GetMapping("/view/{cuisineType}/{orderBy}/{search}")
	public String userSearchView(@PathVariable(name = "cuisineType") String cuisineType, @PathVariable(name = "orderBy") String orderBy, @PathVariable(name="search") String search, Model model) {
		
		List<Cuisines> cuisinesList = cuisineService.GetAllCuisinesVisible();
		if(search.equals("default")) {
			if(!cuisineType.equals("all")){
				if(orderBy.equals("descend")) {
					cuisinesList = cuisineService.CuisinePriceDesc(cuisineType);
				}else if(orderBy.equals("ascend") || orderBy.equals("none")) {
					cuisinesList = cuisineService.CuisinePriceAsc(cuisineType);
				}
			}else if(orderBy.equals("ascend")) {
				cuisinesList = cuisineService.GetAllCuisinesVisibleAsc();
			}else if(orderBy.equals("descend")) {
				cuisinesList = cuisineService.GetAllCuisinesVisibleDesc();
			}
		}else {
			if(orderBy.equals("ascend")) {
				cuisinesList = cuisineService.SearchCuisineAsc(search);
			}else if(orderBy.equals("descend")) {
				cuisinesList = cuisineService.SearchCuisineDesc(search);
			}else {
				cuisinesList = cuisineService.SearchCuisine(search);
			}
		}
		
		model.addAttribute("search", search);
		
		model.addAttribute("cuisines", cuisinesList);
		
		model.addAttribute("cuisineType", cuisineType);
		
		Boolean admin = null;
		
		if(UserWebController.username!=null) {
			Users user = userService.getUserByUsername(UserWebController.username);
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
		
		cuisineService.saveCuisine(cuisine);
		
		FileUploadUtil.saveFile(uploadDir, fileName, multipartFile);
		
		return "redirect:/admin";
		
	}
	
	@GetMapping("/update_item/{cId}")
	public String editItem(@PathVariable(name = "cId") Integer Id, Model model) {
		
		model.addAttribute("cuisines", cuisineService.getCuisineById(Id));
		
		return "update_item";
		
	}
	
	@PostMapping(value = "/save_update")
	public String saveUpdateItem(@ModelAttribute("cuisines") Cuisines cuisine, @RequestParam("image") MultipartFile multipartFile) throws IOException {
		
		String uploadDir = "src/main/resources/static/images/";
		
		String savedFileName = ("/images/" + StringUtils.cleanPath(multipartFile.getOriginalFilename()));
		
		String fileName = StringUtils.cleanPath(multipartFile.getOriginalFilename());
		
		cuisine.setPicture(savedFileName);
		
		cuisineService.saveCuisine(cuisine);
		
		FileUploadUtil.saveFile(uploadDir, fileName, multipartFile);
		
		return "redirect:/admin";
	}
	
	
	@PostMapping(value = "/save_delete/{cId}")
	public String saveDeleteItem(@PathVariable(name="cId") Integer Id) {
		
		cuisineService.deleteCuisine(Id);
		
		return "redirect:/admin";
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}