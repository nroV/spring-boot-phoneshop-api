package com.setec.controller;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.setec.dto.BrandDTO;
import com.setec.enity.Brand;
import com.setec.mapper.MapperDTO;
import com.setec.service.BrandService;

import jakarta.websocket.server.PathParam;
import jakarta.xml.ws.Response;
import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping("brands")
public class BrandController {
	private BrandService brandService;
	@PostMapping({"/home","/"})
	public ResponseEntity<?> brandService(@RequestBody BrandDTO branddto){
		
		Brand brand = brandService.create(MapperDTO.ToBrand(branddto));
		
		MapperDTO.ToDTO(brand);
		return ResponseEntity.ok(MapperDTO.ToDTO(brand));
	}	
	
	@GetMapping({"/{id}"})
	public ResponseEntity<?> getbyid(@PathVariable("id")  Integer brandid){
		BrandDTO branddto = MapperDTO.ToDTO(brandService.findbyid(brandid));
		return ResponseEntity.status(HttpStatus.OK).body(branddto);
		
		
	}
	@PutMapping({"/{id}"})
	public ResponseEntity<?> updatebyid(@PathVariable("id")  Integer brandid, 
			@RequestBody BrandDTO branddto){
		BrandDTO objdto = brandService.updatebyid(brandid, branddto);
		
		return ResponseEntity.status(HttpStatus.OK).body(objdto);
		
		
	}
	@DeleteMapping({"/{id}"})
	public ResponseEntity<?> deletebyid(@PathVariable("id")  Integer brandid){
		Brand deletedbrand = brandService.deletebyid(brandid);
		
		return ResponseEntity.status(HttpStatus.OK).body(deletedbrand);
		
		
	}

}
