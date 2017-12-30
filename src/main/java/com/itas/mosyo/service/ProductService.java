package com.itas.mosyo.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.itas.mosyo.model.Product;
import com.itas.mosyo.repository.ProductRepository;

@Service
public class ProductService {

	@Autowired
	ProductRepository productRepository;
	
	public List<Product> findAllProducts(){
		
		return productRepository.findAllProducts();
		
	}
	
	@Transactional
	public Product save(Product product){
		
		return productRepository.save(product);
		
	}
	
	@Transactional
	public void delete(Product product){
		
		productRepository.delete(product);
		
	}
	
	public Product findById(long id){
		
		return productRepository.findById(id);
		
	}
	
	public Product findByCode(String code){
		
		return productRepository.findByCode(code);
		
	}
	
	public int getProductCountOfColor(long id){
		
		return productRepository.getProductCountOfColor(id);
		
	}
	
	
}
