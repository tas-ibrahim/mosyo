package com.itas.mosyo.model;

import javax.persistence.Entity;

@Entity
public class Color extends BaseModel{

	String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
}
