package com.capg.rest.handler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import com.capg.rest.exception.ProductNotFoundException;
import com.capg.rest.exception.ReviewNotFoundException;

//global exception handler class

@ControllerAdvice
public class RestAppExceptionHandler extends ResponseEntityExceptionHandler
{
	@ExceptionHandler(ProductNotFoundException.class)
	public ResponseEntity<String> productNotFoundExceptionHndler(ProductNotFoundException ex)
	{
		System.out.println(ex);
		return new ResponseEntity<String>("Product Not Found",HttpStatus.NO_CONTENT);
	}
	@ExceptionHandler(ReviewNotFoundException.class)
	public ResponseEntity<String>  reviewNotFoundExceptionHandlerHndler(ReviewNotFoundException ex)
	{
		System.out.println(ex);
		return new ResponseEntity<String>("Review Not Found",HttpStatus.NO_CONTENT);
	}

}
