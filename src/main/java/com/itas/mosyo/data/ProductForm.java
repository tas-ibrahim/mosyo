package com.itas.mosyo.data;

import org.springframework.web.multipart.MultipartFile;

import com.itas.mosyo.model.Product;

public class ProductForm {

	Product product;
	
	MultipartFile imageFile;

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public MultipartFile getImageFile() {
		return imageFile;
	}

	public void setImageFile(MultipartFile imageFile) {
		this.imageFile = imageFile;
	}
	
}
