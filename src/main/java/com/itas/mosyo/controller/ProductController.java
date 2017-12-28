package com.itas.mosyo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.itas.mosyo.data.ProductForm;
import com.itas.mosyo.data.RestResponse;
import com.itas.mosyo.model.Offer;
import com.itas.mosyo.model.Product;
import com.itas.mosyo.service.OfferService;
import com.itas.mosyo.service.ProductService;
import com.itas.mosyo.util.StringUtil;
import com.itas.mosyo.validator.OfferValidator;

@Controller
public class ProductController extends BaseController{

	@Autowired
	ProductService productService;
	
	@Autowired
	OfferService offerService;
	
	@Autowired
	OfferValidator offerValidator;
	
	public ProductController(){
		
		super("home");
		
	}
	
	@RequestMapping(value = "/product/{id}", method = RequestMethod.GET)
	public String detail(@PathVariable("id") long id, Model model){
		
		Product product = productService.findById(id);
		
		model.addAttribute("product", product);
		
		return render("detail");
		
	}

	@RequestMapping(value = "/offer/{id}", method = RequestMethod.GET)
	public String offer(@PathVariable("id") long id, Model model){
		
		Product product = productService.findById(id);
		
		model.addAttribute("product", product);
		
		return 	"modal.offer";
		
	}
	
	@ResponseBody
	@PostMapping("/offer")
	public RestResponse saveOffer(Offer offer, BindingResult result){
		
		offerValidator.validate(offer, result);
		
		if(result.hasErrors())
			return createRestResponse(result.getFieldErrors());
		
		offerService.save(offer);
		
		return new RestResponse(true, null);
		
	}
	
}
