package com.itas.mosyo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.itas.mosyo.model.Color;
import com.itas.mosyo.repository.ColorRepository;

@Service
public class ColorService {

	@Autowired
	ColorRepository colorRepository;
	
	public List<Color> findAll(){
		
		return colorRepository.findAll();
	}
	
	public Color findById(long id){
		
		return colorRepository.findById(id);
		
	}
	
}
