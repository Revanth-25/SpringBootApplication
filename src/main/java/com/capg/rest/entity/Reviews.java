package com.capg.rest.entity;

import com.capg.rest.dto.Productdto;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Transient;

@Entity
public class Reviews {
	@Id
	@Column(name="rev_id")
	private int reviewId;
	@Column(name="prod_id")
	private int productId;
	@Column(name="rating")
	private int productRating;
	@Column(name="re_desc")
	private String reviewDescription;
	
	
	@Transient
	Productdto productdto;
	

	public Productdto getProductdto() {
		return productdto;
	}

	public void setProductdto(Productdto productdto) {
		this.productdto = productdto;
	}

	public Reviews() {
		
	}

	public Reviews(int reviewId, int productId, int productRating, String reviewDescription) {
		super();
		this.reviewId = reviewId;
		this.productId = productId;
		this.productRating = productRating;
		this.reviewDescription = reviewDescription;
	}

	public int getReviewId() {
		return reviewId;
	}

	public void setReviewId(int reviewId) {
		this.reviewId = reviewId;
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public int getProductRating() {
		return productRating;
	}

	public void setProductRating(int productRating) {
		this.productRating = productRating;
	}

	public String getReviewDescription() {
		return reviewDescription;
	}

	public void setReviewDescription(String reviewDescription) {
		this.reviewDescription = reviewDescription;
	}

	@Override
	public String toString() {
		return "Reviews [reviewId=" + reviewId + ", productId=" + productId + ", productRating=" + productRating
				+ ", reviewDescription=" + reviewDescription + "]";
	}
	

}
