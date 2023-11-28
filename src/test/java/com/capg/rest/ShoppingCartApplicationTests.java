package com.capg.rest;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.internal.stubbing.answers.DoesNothing;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.capg.rest.entity.Product;
import com.capg.rest.repository.ProductRepository;
import com.capg.rest.service.ProductService;

//import jakarta.annotation.security.RunAs;

//@RunAs(SpringRunner.class)
@SpringBootTest
class ShoppingCartApplicationTests {

	@Autowired
	ProductService productService; //testing for product service
	
	@MockBean   //to use mock object instead of actual object
	ProductRepository productRepository;
	
	//to test get all products method from repository
	
	@Test
	void getAllProductsTest() {
		
		List<Product> plist = Arrays.asList(new Product(7001,"Tooth paste","Nice paste",15,150),new Product(7002,"Horlix","Instant energy",150,115));
		when(productRepository.findAll()).thenReturn(plist);
		assertEquals(2,productService.getAllProducts().size());
	}

	@Test
	void insertOrModifyTest() 
	{
		Product p = new Product(7001,"Tooth paste","Nice paste",15,150);
		when(productRepository.save(p)).thenReturn(p);
		assertEquals(true, productService.insertOrModifyProduct(p));
	}
//	@Test
//	public void deleteProductById() {
//     int productId = 7001;
//     List<Product> plist = Arrays.asList(new Product(7001,"Tooth paste","Nice paste",15,150),new Product(7002,"Horlix","Instant energy",150,115));
//     
//     doNothing().when(productRepository.saveAll(plist));
////     when(productRepository.deleteById(productId)).thenReturn(true);
////     assertEquals(true,productService.deleteProductById(productId));
//     doNothing().when(productRepository).deleteById(productId);
//	}
}
