package com.setec.service;

import java.util.List;

import com.setec.dto.BrandDTO;
import com.setec.enity.Brand;

public interface BrandService {

	List<Brand> getall();
	List<Brand> getall(String name);
	Brand create(Brand branddto);
	
	Brand findbyid(Integer id);
	
	BrandDTO updatebyid(Integer id,BrandDTO branddto);
	
	Brand deletebyid(Integer id);
	
	
	
	



	
}
