package com.setec.service;



import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;

import com.setec.dto.BrandDTO;
import com.setec.enity.Brand;
import com.setec.exception.BrandNotFoundException;
import com.setec.mapper.MapperDTO;
import com.setec.repository.BrandRepository;

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
		
		return MapperDTO.ToDTO(updatebrand);
		
	}

	@Override
	public Brand deletebyid(Integer id) {
		// TODO Auto-generated method stub
		
		Brand brand = findbyid(id);
	
		brandRepository.deleteById(id); 
		
		return brand;
	}

}
