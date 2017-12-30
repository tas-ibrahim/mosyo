package com.itas.mosyo.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

@Entity
public class Product extends BaseModel{

	@Column(unique = true)
	String code;
	
	@Column(nullable = false)
	String imageUrl;
	
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "product_color", joinColumns = @JoinColumn(name = "product_id"),
		inverseJoinColumns = @JoinColumn(name = "color_id"))
	List<Color> colors;
	
	@OneToMany(mappedBy = "product", cascade = CascadeType.ALL)
	List<Offer> offers;
	
	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	public List<Color> getColors() {
		return colors;
	}

	public void setColors(List<Color> colors) {
		this.colors = colors;
	}
	
	public List<Long> getColorIds(){
		
		List<Long> ids = new ArrayList<Long>();
		
		if(colors != null){
			
			for(Color color : colors){
				ids.add(color.getId());
			}
			
		}
		
		return ids;
		
	}
	
	public String getColorNames(){
		
		List<String> names = new ArrayList<String>();
		
		if(colors != null){
			
			for(Color color : colors){
				names.add(color.getName());
			}
			
		}
		
		return String.join(",", names);
		
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public List<Offer> getOffers() {
		return offers;
	}

	public void setOffers(List<Offer> offers) {
		this.offers = offers;
	}

}
