package com.itas.mosyo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;

import com.itas.mosyo.model.Product;

public interface ProductRepository extends BaseRepository<Product>{
	
	public Product findByCode(String code);
	
	@Query("select p from Product p order by createTime desc")
	public List<Product> findAllProducts();
	
	public Product findById(long id);
	
}