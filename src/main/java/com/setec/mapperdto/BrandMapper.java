package com.setec.mapperdto;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.setec.dto.BrandDTO;
import com.setec.enity.Brand;

@Mapper
public interface BrandMapper {
			BrandMapper Instance = Mappers.getMapper(BrandMapper.class);
			Brand tobrand(BrandDTO brandto);
			BrandDTO tobrandDto(Brand brand);
}
