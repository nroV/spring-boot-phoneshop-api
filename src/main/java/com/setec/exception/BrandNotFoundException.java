package com.setec.exception;

public class BrandNotFoundException extends RuntimeException {

	
	public BrandNotFoundException(String classmodel,int id) {
	
		 super(classmodel +" is not found with the following id of "+id);
	}

}
