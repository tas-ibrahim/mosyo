package com.itas.mosyo.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;

import com.itas.mosyo.model.Product;
import com.itas.mosyo.service.ProductService;
import com.itas.mosyo.util.StringUtil;

public class StringToProductConverter implements Converter<String, Product>{

	@Autowired
	ProductService productService;
	
	@Override
	public Product convert(String idStr) {

		if(StringUtil.isNothing(idStr))
			return null;
		
		try{
			
			long id = Long.parseLong(idStr.trim());
			
			return productService.findById(id);
			
		}
		catch(Exception ex){
		
			return null;
			
		}
		
		
	}

	
	
}
