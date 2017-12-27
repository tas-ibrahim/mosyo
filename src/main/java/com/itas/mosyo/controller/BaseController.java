package com.itas.mosyo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.validation.FieldError;

import com.itas.mosyo.data.RestError;
import com.itas.mosyo.data.RestResponse;


public abstract class BaseController {

	private String viewBase = "";

	protected final int DEFAULT_PAGE_SIZE = 15;
	
	@Autowired
	MessageSource messageSource;
	
	
	protected BaseController() {

	}

	protected BaseController(String viewBase) {

		if (viewBase != null) {
			
			viewBase = viewBase.trim();
			
			if (viewBase.length() > 0)
				this.viewBase = viewBase + ".";
		}
	}

	String render(String viewName) {
		return viewBase + viewName;
	}

	public String getViewBase() {
		return viewBase;
	}
	
	protected String getMessage(String code, Object[] args, String defaultMessage){
    	
    	return messageSource.getMessage(code, args, defaultMessage, null);
    }
	
	protected String getMessage(String code, String defaultMessage){
    	
    	return messageSource.getMessage(code, null, defaultMessage, null);
    }
	
	protected String getMessage(String code){
    	
    	return messageSource.getMessage(code, null, null);
    }
	
	protected RestResponse createRestResponse(List<FieldError> errors){
	    	
		return createRestResponse(errors, null);
	    	
	}
	
	protected RestResponse createRestResponse(List<FieldError> errors, String message){
	    
    	RestResponse response = new RestResponse();
    	response.setAlertMsg(message);
    	
    	response.setSuccess(false);
    	
		for(FieldError error : errors)
			if(error.getArguments() != null)
				response.addError(new RestError(error.getField(), getMessage(error.getCode(), error.getArguments(), null)));
			else
				response.addError(new RestError(error.getField(), getMessage(error.getCode(), null)));
    	
		return response;
    	
    }
	

}
