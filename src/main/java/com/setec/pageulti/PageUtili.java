package com.setec.pageulti;

import java.awt.print.Pageable;

import org.springframework.data.domain.PageRequest;





public interface PageUtili {

	
	
	 int DEFAULT_PAGE = 1 ;
	 int DEFAULT_LIMIT = 2;
	 String PAGE_NAME ="page";
	 String LIMIT_NAME ="limit";
	 static Pageable getpageble(int page,int size) {
		 
		 if(page < DEFAULT_PAGE) {
			 page = DEFAULT_PAGE;
		 }
		 if(size <DEFAULT_LIMIT ) {
			 size = DEFAULT_LIMIT;
		 }
		 
		 Pageable pageable = (Pageable) PageRequest.of(page, size);

		 return pageable;
	 }
	
}
