package com.setec.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import jakarta.xml.ws.Response;

@ControllerAdvice
public class AppException {

	
		@ExceptionHandler(BrandNotFoundException.class)
		public ResponseEntity<ResponseMessageException> handleNotFoundByIdBrand(BrandNotFoundException exp){
			ResponseMessageException errorResponse = new ResponseMessageException();
			errorResponse.setMessage(exp.getMessage());
			errorResponse.setStatusCode(HttpStatus.NOT_FOUND.value());
//			return new ResponseEntity<ResponseMessageException>(response,HttpStatus.NOT_FOUND);
			
			return ResponseEntity.status(errorResponse.getStatusCode()).body(errorResponse);
			
		}
	
}
