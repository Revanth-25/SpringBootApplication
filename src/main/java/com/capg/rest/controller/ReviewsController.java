package com.capg.rest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capg.rest.entity.Reviews;
import com.capg.rest.exception.ReviewNotFoundException;
import com.capg.rest.service.ReviewsService;

@RestController
@RequestMapping("/reviews")
public class ReviewsController 
{
     @Autowired
     ReviewsService reviewsService;
     
     @GetMapping(produces="application/json")
     public ResponseEntity<List<Reviews>> getAllReview()
     {
    	 return new ResponseEntity<List<Reviews>> (reviewsService.getAllReview(),HttpStatus.OK);
     }
     @GetMapping(value="/{reviewId}",produces="application/json")
     public ResponseEntity<Reviews> getReviewById(@PathVariable int reviewId)
     {
    	 return new ResponseEntity<Reviews>( reviewsService.getReviewById(reviewId),HttpStatus.OK);
     }
     @GetMapping(value="/product/{productId}",produces="application/json")
     public ResponseEntity<Reviews> getReviewByProductId(@PathVariable int productId)
     {
    	 return new ResponseEntity<>( reviewsService.getReviewByProductId(productId),HttpStatus.OK);
     }
         
//     @ExceptionHandler(ReviewNotFoundException.class)
//     public HttpStatus reviewNotFoundExceptionHandler(ReviewNotFoundException e)
//     {
//    	 System.out.println(e);
//    	 return HttpStatus.NO_CONTENT;
//     }
     
}
