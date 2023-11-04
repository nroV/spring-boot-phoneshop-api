package com.setec.service;

import java.util.List;
import java.util.Map;

import com.setec.dto.BrandDTO;
import com.setec.enity.Brand;

public interface BrandService {


	List<Brand> getall(String name);
	List<Brand> getall(Map<String,String> name);
	List<Brand> getall();
	Brand create(Brand branddto);
	
	Brand findbyid(Integer id);
	
	BrandDTO updatebyid(Integer id,BrandDTO branddto);
	
	Brand deletebyid(Integer id);
	
	
	
	



	
}
