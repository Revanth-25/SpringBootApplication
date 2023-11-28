package com.capg.rest.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

import com.capg.rest.dto.Productdto;
//import com.capg.rest.entity.Product;
import com.capg.rest.entity.Reviews;
import com.capg.rest.exception.ReviewNotFoundException;
import com.capg.rest.repository.ReviewsRepository;

@Service
public class ReviewsService {
	  @Autowired
	  ReviewsRepository reviewsRepository;
	  
	  @Autowired
	  RestTemplate restTemplate;
	  
	  
	  @Transactional(readOnly=true)
	  public List<Reviews> getAllReview()
	  {
		  return reviewsRepository.findAll();
	  }
	  
	  @Transactional(readOnly=true)
	  public Reviews getReviewById(int reviewId)
	  {
		  Optional<Reviews> or = reviewsRepository.findById(reviewId);
		  if(or.isPresent())
			  return or.get();
		  throw new ReviewNotFoundException("Review Does Not Exist with Id: " +reviewId);
	  }

	  @Transactional(readOnly=true)
	  public Reviews getReviewByProductId(int productId) throws ReviewNotFoundException
	  {
		  Optional<Reviews> or = reviewsRepository.findByProductId(productId);
		  if(or.isPresent())
		  {
			  Productdto p = restTemplate.getForEntity("http://localhost:8095/product/{productId}",Productdto.class,productId).getBody();
			  Reviews r = or.get();
			  r.setProductdto(new com.capg.rest.dto.Productdto());
			  r.getProductdto().setProductId(productId);
			  r.getProductdto().setProductName(p.getProductName());
			  r.getProductdto().setProductDescription(p.getProductDescription());
			  r.getProductdto().setProductPrice(p.getProductPrice());
			  r.getProductdto().setProductQuantity(p.getProductQuantity());
			  return r;
		  }  
		  throw new ReviewNotFoundException("Review Does Not Exist with Id: " +productId);
	  }

}
