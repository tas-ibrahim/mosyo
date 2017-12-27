package com.itas.mosyo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.itas.mosyo.model.Product;
import com.itas.mosyo.service.ProductService;

@Controller
public class ProductController extends BaseController{

	@Autowired
	ProductService productService;
	
	public ProductController(){
		
		super("home");
		
	}
	
	@RequestMapping(value = "/product/{id}", method = RequestMethod.GET)
	public String detail(@PathVariable("id") long id, Model model){
		
		Product product = productService.findById(id);
		
		model.addAttribute("product", product);
		
		return render("detail");
		
	}
	
}
