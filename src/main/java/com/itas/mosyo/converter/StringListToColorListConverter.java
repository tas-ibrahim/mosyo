package com.itas.mosyo.converter;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;

import com.itas.mosyo.model.Color;
import com.itas.mosyo.service.ColorService;


public class StringListToColorListConverter implements Converter<String[], List<Color>>{

	@Autowired
	ColorService colorService;
	
	@Override
	public List<Color> convert(String[] ids) {

		List<Color> colors = new ArrayList<Color>();
		
		if(ids != null){
			
			for(String id : ids){
				
				try{
					
					Color color = colorService.findById(Long.parseLong(id));
					
					if(color != null)
						colors.add(color);
					
				}
				catch(Exception ex){
					
				}
				
			}
			
		}
		
		return colors;
	}

}
