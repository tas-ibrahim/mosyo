package com.itas.mosyo.validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.itas.mosyo.data.ProductForm;
import com.itas.mosyo.model.Product;
import com.itas.mosyo.service.ProductService;
import com.itas.mosyo.util.StringUtil;

@Component
public class ProductValidator implements Validator{

	@Autowired
	ProductService productService;
	
	@Override
	public boolean supports(Class<?> clazz) {
		return ProductForm.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {

		ProductForm productForm = (ProductForm) target;
		
		Product product = productForm.getProduct();
		
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "product.code", "product.code.invalid");
		
		if( !StringUtil.isNothing(product.getCode())){
			
			Product existsProduct = productService.findByCode(product.getCode());
			
			if(existsProduct != null && (product.getId() == null || existsProduct.getId().longValue() != product.getId().longValue()))
				errors.rejectValue("product.code", "product.code.already.used");
			
			
		}
		
		if( product.getId() == null && productForm.getImageFile() == null)
			errors.rejectValue("imageFile", "product.image.invalid");
		
		
		if( product.getColors() == null ||  product.getColors().size() == 0)
			errors.rejectValue("product.colors", "product.colors.invalid");
	}

	
	
}
