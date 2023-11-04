package com.setec.service;



import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;

import com.setec.dto.BrandDTO;
import com.setec.enity.Brand;
import com.setec.exception.BrandNotFoundException;
import com.setec.mapper.MapperDTO;
import com.setec.mapperdto.BrandMapper;
import com.setec.pageulti.PageUtili;
import com.setec.repository.BrandRepository;
import com.setec.spec.BrandFilter;
import com.setec.spec.BrandSpec;

import lombok.AllArgsConstructor;
@AllArgsConstructor
@Service
public class BrandServiceImp implements  BrandService {

	private BrandRepository brandRepository;
	
	@Override
	public Brand create(Brand brand) {
		// TODO Auto-generated method stub
		return brandRepository.save(brand);
		
	}

	@Override
	public Brand findbyid(Integer id) {
		// TODO Auto-generated method stub
		Optional<Brand>	 brandOptional = brandRepository.findById(id);
		if(brandOptional.isPresent()) {
			return brandOptional.get();
		}
		else {
			throw new BrandNotFoundException("Brand",id);
		}
		
	}

	@Override
	public BrandDTO updatebyid(Integer id, BrandDTO branddto) {
		// TODO Auto-generated method stub
		Brand updatebrand = findbyid(id);
		updatebrand.setName(branddto.getName());
		brandRepository.save(updatebrand);
		return BrandMapper.Instance.tobrandDto(updatebrand);
		
//		return MapperDTO.ToDTO(updatebrand);
		
	}

	@Override
	public Brand deletebyid(Integer id) {
		// TODO Auto-generated method stub
		
		Brand brand = findbyid(id);
	
		brandRepository.deleteById(id); 
		
		return brand;
	}

	@Override
	public List<Brand> getall() {
		// TODO Auto-generated method stub
		return brandRepository.findAll();
	}

//	@Override
//	public List<Brand> getall(String name) {
//		// TODO Auto-generated method stub
//		return brandRepository.findByNameContains(name);
//	}

	@Override
	public List<Brand> getall(Map<String, String> param) {
		// TODO Auto-generated method stub
		System.out.println("Hello world");
		BrandFilter brandFilter = new BrandFilter()	;
		System.out.println(param);
		System.out.println(param.containsKey("name"));
		if(param.containsKey("name") == true) {
			System.out.println("True");
			brandFilter.setName(param.get("name"));
			
		}
		if(param.containsKey("id") == true) {
			System.out.println("True");
			brandFilter.setId(Integer.parseInt(param.get("id")));
		}
		if(param.containsKey(PageUtili.PAGE_NAME)) {
			
		}
			if(param.containsKey(PageUtili.LIMIT_NAME)) {
			
		}
		BrandSpec brandspec = new BrandSpec(brandFilter);
		return brandRepository.findAll(brandspec);
	}

	@Override
	public List<Brand> getall(String name) {
		// TODO Auto-generated method stub
		return null;
	}



}
