package com.setec.service;

import com.setec.dto.BrandDTO;
import com.setec.enity.Brand;

public interface BrandService {

	
	
	Brand create(Brand branddto);
	
	Brand findbyid(Integer id);
	
	BrandDTO updatebyid(Integer id,BrandDTO branddto);
	
	Brand deletebyid(Integer id);
	
}
