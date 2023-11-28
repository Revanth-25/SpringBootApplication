package com.capg.rest.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import com.capg.rest.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Integer>{
	
	Optional<Product> findByProductName(String productName);

}
