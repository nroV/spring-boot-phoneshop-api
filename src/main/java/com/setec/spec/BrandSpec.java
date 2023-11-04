package com.setec.spec;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.jpa.domain.Specification;

import com.setec.enity.Brand;

import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import lombok.Data;
@Data
public class BrandSpec implements Specification<Brand>{

	private final BrandFilter brandFilter;
	
	List<Predicate> predicate = new ArrayList<>();
	@Override
	public Predicate toPredicate(Root<Brand> brand,
			CriteriaQuery<?> query, 
			CriteriaBuilder cb) {
		// TODO Auto-generated method stub
		if( brandFilter.getName() != null) {
		 Predicate name = cb.like(brand.get("name"),
				"%"+brandFilter.getName()+"%");
		 
		 predicate.add(name);

		
		}
		
		if( brandFilter.getId() != null) {
			 Predicate id = brand.get("id").in(brandFilter.getId() );
				 
				 predicate.add(id);
		}
		Predicate[] array = predicate.toArray(new Predicate[0]);

		return cb.and(array);

		
//		return like;
	}

}
