package com.itas.mosyo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.itas.mosyo.model.Offer;
import com.itas.mosyo.repository.OfferRepository;

@Service
public class OfferService {

	@Autowired
	OfferRepository offerRepository;
	
	public Offer save(Offer offer){
		
		return offerRepository.save(offer);
		
	}
	
	public void delete(Offer offer){
		
		offerRepository.delete(offer);
		
	}
	
	public Page<Offer> getPage(int pageNumber){
		
		return offerRepository.findAll(new PageRequest(pageNumber, 20, Direction.DESC, "createTime"));
		
	}
	
}
