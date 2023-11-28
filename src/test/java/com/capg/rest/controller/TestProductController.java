package com.capg.rest.controller;

//import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import static org.mockito.Mockito.when;

import java.util.List;
import java.util.Arrays;

import com.capg.rest.entity.Product;
import com.capg.rest.service.ProductService;
import com.fasterxml.jackson.databind.ObjectMapper;


@WebMvcTest(ProductController.class)
class TestProductController 
{
	@MockBean
	ProductService productService;
	
	@Autowired
	MockMvc mockMvc; //a special class to perform mock operations.

	@Test
	public void getAllProductsTest() throws Exception
	{
		List<Product>  plist = Arrays.asList(new Product(7001,"Tooth paste","Nice paste",15,150),new Product(7002,"Horlix","Instant energy",150,115));
		when(productService.getAllProducts()).thenReturn(plist);
		mockMvc.perform(get("/product").contentType(MediaType.APPLICATION_JSON)).andExpect(status().isOk());
		
	}
	
	@Test
	public void addProductDetailsTest() throws Exception
	{
		Product p = new Product(7001,"Tooth paste","Nice paste",15,150);
		when(productService.insertOrModifyProduct(p)).thenReturn(true);
		mockMvc.perform(post("/product").contentType(MediaType.APPLICATION_JSON).content(new ObjectMapper().writeValueAsString(p))).andExpect(status().isOk());
	}
	
	@Test 
	public void deleteProductByIdTest() throws Exception
		{
		int productId= 7001;
		when(productService.deleteProductById(productId)).thenReturn(true);
	    mockMvc.perform(delete("/product/{productId}",productId).contentType(MediaType.APPLICATION_JSON)).andExpect(status().isOk());
	}

}
