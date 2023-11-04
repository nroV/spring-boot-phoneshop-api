package com.setec.controller;


import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.setec.dto.BrandDTO;
import com.setec.enity.Brand;
import com.setec.mapper.MapperDTO;
import com.setec.mapperdto.BrandMapper;
import com.setec.service.BrandService;

import jakarta.websocket.server.PathParam;
import jakarta.xml.ws.Response;
import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping("brands")
public class BrandController {
	private BrandService brandService;
	
	@GetMapping
	public ResponseEntity<?> filter(@RequestParam Map<String,String> param){

		List<BrandDTO>  branddto = 
				brandService.getall(param)
				.stream().map(brand->BrandMapper.Instance.tobrandDto(brand))
		.collect(Collectors.toList());
		
		return ResponseEntity.ok(branddto);
		
		
	}
//	@GetMapping
//	public ResponseEntity<?> getall(){
//
//		List<BrandDTO>  branddto = 
//				brandService.getall()
//				.stream().map(brand->BrandMapper.Instance.tobrandDto(brand))
//		.collect(Collectors.toList());
//		
//		return ResponseEntity.ok(branddto);
//		
//		
//	}
//	@GetMapping
//	public ResponseEntity<?> getbyname(@RequestParam String name){
//
//		List<BrandDTO>  brandtwo = 
//				brandService.getall(name)
//				.stream().map(brand->BrandMapper.Instance.tobrandDto(brand))
//		.collect(Collectors.toList());
//		
//		return ResponseEntity.ok(brandtwo);
//		
//		
//	}
	@PostMapping({"/home","/"})
	public ResponseEntity<?> brandService(@RequestBody BrandDTO branddto){
		
		Brand brand = brandService.create(MapperDTO.ToBrand(branddto));
		
//		MapperDTO.ToDTO(brand);
		
//		BrandMapper.Instance.tobrandDto(brand);
		return ResponseEntity.ok(BrandMapper.Instance.tobrandDto(brand));
	}	

	@GetMapping({"/{id}"})
	public ResponseEntity<?> getbyid(@PathVariable("id")  Integer brandid){
//		BrandDTO branddto = MapperDTO.ToDTO(brandService.findbyid(brandid));
		BrandDTO branddto = BrandMapper.Instance.tobrandDto(brandService.findbyid(brandid));
		
		return ResponseEntity.status(HttpStatus.OK).body(branddto);
		
		
	}
	@PutMapping({"/{id}"})
	public ResponseEntity<?> updatebyid(@PathVariable("id")  Integer brandid, 
			@RequestBody BrandDTO branddto){
//		BrandDTO objdto = brandService.updatebyid(brandid, branddto);
		BrandDTO objdto =	brandService.updatebyid(brandid, branddto);
		return ResponseEntity.status(HttpStatus.OK).body(objdto);
		
		
	}
	@DeleteMapping({"/{id}"})
	public ResponseEntity<?> deletebyid(@PathVariable("id")  Integer brandid){
		Brand deletedbrand = brandService.deletebyid(brandid);
		
		return ResponseEntity.status(HttpStatus.OK).body(deletedbrand);
		
		
	}

}
