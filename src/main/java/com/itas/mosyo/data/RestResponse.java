package com.itas.mosyo.data;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(value = Include.NON_NULL)
public class RestResponse {

	private boolean success;
	
	private String alertMsg;
	
	private Object object;
	
	private List<RestError> errors;

	public RestResponse(){
		
	}
	
	public RestResponse(boolean success, String alertMsg){
		
		this.success = success;
		this.alertMsg = alertMsg;
		
	}
	
	public RestResponse(boolean success, Object object) {
	
		this.success = success;
		this.object = object;
	}

	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}

	public String getAlertMsg() {
		return alertMsg;
	}

	public void setAlertMsg(String alertMsg) {
		this.alertMsg = alertMsg;
	}

	public List<RestError> getErrors() {
		return errors;
	}

	public void setErrors(List<RestError> errors) {
		this.errors = errors;
	}
	
	public void addError(RestError error){
		
		if(errors == null)
			errors = new ArrayList<RestError>();
		
		errors.add(error);
		
	}

	public Object getObject() {
		return object;
	}

	public void setObject(Object object) {
		this.object = object;
	}

//	public Map<String, Object> getObjects() {
//		return objects;
//	}
//
//	public void setObjects(Map<String, Object> objects) {
//		this.objects = objects;
//	}
//	
//	public void addObject(String key, Object objectId){
//		
//		if(objects == null)
//			objects = new HashMap<String, Object>();
//		
//		objects.put(key, objectId);
//		
//	}
	
}
