package com.itas.mosyo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.itas.mosyo.model.Product;

public interface ProductRepository extends BaseRepository<Product>{
	
	public Product findByCode(String code);
	
	@Query("select p from Product p order by createTime desc")
	public List<Product> findAllProducts();
	
	public Product findById(Long id);
	
	@Query("select count(p) from Product p inner join p.colors c where c.id = :id")
	public int getProductCountOfColor(@Param("id") long id);
	
}