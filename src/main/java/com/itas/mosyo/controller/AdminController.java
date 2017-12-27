package com.itas.mosyo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.itas.mosyo.data.ProductForm;
import com.itas.mosyo.data.RestResponse;
import com.itas.mosyo.model.Product;
import com.itas.mosyo.service.ColorService;
import com.itas.mosyo.service.ImageService;
import com.itas.mosyo.service.ProductService;
import com.itas.mosyo.util.StringUtil;
import com.itas.mosyo.validator.ProductValidator;

@Controller
public class AdminController extends BaseController{

	@Autowired
	ProductService productService;
	
	@Autowired
	ProductValidator productValidator;
	
	@Autowired
	ColorService colorService;
	
	@Autowired
	ImageService imageService;
	
	
	public AdminController(){
		
		super("admin");
		
	}
	
	@GetMapping("/login")
	public String login(){
		
		return render("login");
		
	}
	
	@GetMapping("/admin")
	public String index(Model model){
		
		model.addAttribute("products", productService.findAllProducts());
		
		return render("index");
		
	}
	
	@GetMapping("/admin/product/save")
	public String renderProductSaveForm(@ModelAttribute("productForm") ProductForm productForm, Model model){
		
		model.addAttribute("product", productForm.getProduct());
		model.addAttribute("colors", colorService.findAll());
		
		return "modal.product_save";
		
	}
	
	@ModelAttribute("productForm")
	public ProductForm productForm(@RequestParam(name = "id", required = false) Long id){
		
		ProductForm productForm = new ProductForm();
		Product product = null;
		
		if(id != null){
			
			product = productService.findById(id);
			
		}
		
		if(product == null)
			product = new Product();
		
		productForm.setProduct(product);
		
		return productForm;
		
	}
	
	
	@ResponseBody
	@PostMapping("/admin/product/save")
	public RestResponse saveProduct(@ModelAttribute("productForm") ProductForm productForm, BindingResult result){
		
		productValidator.validate(productForm, result);
		
		if(result.hasErrors())
			return createRestResponse(result.getFieldErrors());
		
		Product product = productForm.getProduct();
		
		if(productForm.getImageFile() == null){
			
			if( StringUtil.isNothing(product.getImageUrl())){
				result.rejectValue("imageFile", "image.upload.error");
				return createRestResponse(result.getFieldErrors());
			}
			
		}
		else{
			
			String imageName = imageService.uploadToFirebase(productForm.getImageFile());
			
			if(imageName != null){
				
				String existsImage = product.getImageUrl();
				
				product.setImageUrl(imageName);
				
				imageService.deleteImageFromFirebase(existsImage);
				
			}
			
		}
		
		productService.save(product);
		
		return new RestResponse(true, null);
		
	}
		
	@GetMapping("/admin/product/delete")
	@ResponseBody
	public RestResponse deleteProduct(@RequestParam(name = "id") long id){
		
		Product product = productService.findById(id);
		
		if(product == null){
			return new RestResponse(false, null);
		}
		
		productService.delete(product);
		
		imageService.deleteImageFromFirebase(product.getImageUrl());
		
		return new RestResponse(true, null);
		
	}
	
}
