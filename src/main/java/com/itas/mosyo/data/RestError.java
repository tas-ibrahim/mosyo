package com.itas.mosyo.data;

public class RestError {

	private String field;
	
	private String error;

	public RestError(){
		
	}
	
	public RestError(String field, String error) {

		this.field = field;
		this.error = error;
	}

	public String getField() {
		return field;
	}

	public void setField(String field) {
		this.field = field;
	}

	public String getError() {
		return error;
	}

	public void setError(String error) {
		this.error = error;
	}
	
	
}
