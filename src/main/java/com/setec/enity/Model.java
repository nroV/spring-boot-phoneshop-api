package com.setec.enity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="models")
public class Model {
	

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	
	private Integer id;

	private String name;
	
	@ManyToOne
	@JoinColumn(name="BrandId")
	private Brand brand;
}
