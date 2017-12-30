package com.itas.mosyo.validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.itas.mosyo.model.Color;
import com.itas.mosyo.service.ColorService;

@Component
public class ColorValidator implements Validator{

	@Autowired
	ColorService colorService;
	
	@Override
	public boolean supports(Class<?> clazz) {

		return clazz.isAssignableFrom(Color.class);
		
	}

	@Override
	public void validate(Object target, Errors errors) {

		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "color.invalid");
		
		if(!errors.hasErrors()){
			
			Color color = (Color) target;
			color.setName(color.getName().trim());
			
			Color existsColor = colorService.findByName(color.getName());
			
			if(existsColor != null &&(color.getId() == null || color.getId().longValue() != existsColor.getId().longValue()))
				errors.rejectValue("name", "color.already.exists");
			
			
		}
		
		
		
		
		
		
	}

	
	
}
