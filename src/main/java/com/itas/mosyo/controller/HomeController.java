package com.itas.mosyo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.itas.mosyo.model.Product;
import com.itas.mosyo.service.ProductService;

@Controller
public class HomeController extends BaseController{

	@Autowired
	ProductService productService;
	
	public HomeController(){
		
		super("home");
		
	}
	
	
	@GetMapping("/")
	public String index(Model model) {
		
		List<Product> products = productService.findAllProducts();
		
		model.addAttribute("products", products);
		
		return render("index");
		
	}
	
}
