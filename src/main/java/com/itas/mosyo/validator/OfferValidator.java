package com.itas.mosyo.validator;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.itas.mosyo.model.Offer;

public class OfferValidator implements Validator{

	@Value("${email.regex}")
	String emailRegex;
	
	@Override
	public boolean supports(Class<?> clazz) {
		
		return clazz.isAssignableFrom(Offer.class);
		
	}

	@Override
	public void validate(Object target, Errors errors) {
		
		Offer offer = (Offer)target;
		
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "personName", "person-name.invalid");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "phoneNumber", "phone-number.invalid");
		
		if(offer.getProductCount() <= 0)
			errors.rejectValue("productCount", "product-count.invalid");
		
		if(offer.getProduct() == null)
			errors.rejectValue("product", "product.invalid");
		
		
	}

	
	
}
