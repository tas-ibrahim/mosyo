package com.itas.mosyo.model;

import javax.persistence.Embeddable;

@Embeddable
public class Price {

	double value;
	
	Currency currency;

	public double getValue() {
		return value;
	}

	public void setValue(double value) {
		this.value = value;
	}

	public Currency getCurrency() {
		return currency;
	}

	public void setCurrency(Currency currency) {
		this.currency = currency;
	}
	
	public String getPriceText(){
		
		return value + " " + currency.toString();
		
	}
	
}