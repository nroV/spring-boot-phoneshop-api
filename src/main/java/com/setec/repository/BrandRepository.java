package com.setec.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.setec.enity.Brand;

@Repository
public interface BrandRepository extends JpaRepository<Brand, Integer> {

	
	 List<Brand> findByNameContains(String name);
}
