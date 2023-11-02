package com.setec.mapper;
import com.setec.dto.BrandDTO;
import com.setec.enity.Brand;

public class MapperDTO {
	
	
	
	public static Brand ToBrand(BrandDTO brandto) {
			Brand brands = new Brand();
			brands.setName(brandto.getName());
			return brands;
	}
	
	public static BrandDTO ToDTO(Brand brand) {
			BrandDTO branddto = new BrandDTO();
			branddto.setName(brand.getName());
			return branddto;
			
	}
}
