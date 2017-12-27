package com.itas.mosyo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ContactController extends BaseController{

	public ContactController(){
		
		super("contact");
	
	}
	
	@GetMapping("/iletisim")
	public String contact(){
		
		return render("contact");
		
	}
	

	
}
