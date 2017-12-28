package com.itas.mosyo.model;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Entity
public class Offer extends BaseModel{

	@ManyToOne
	Product product;
	
	String personName;
	
	String phoneNumber;
	
	String email;
	
	int productCount;

	public String getPersonName() {
		return personName;
	}

	public void setPersonName(String personName) {
		this.personName = personName;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getProductCount() {
		return productCount;
	}

	public void setProductCount(int productCount) {
		this.productCount = productCount;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

}
