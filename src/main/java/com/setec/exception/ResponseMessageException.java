package com.setec.exception;

import lombok.Data;

@Data
public class ResponseMessageException {

		private String message;
		private int statusCode;
	
}
