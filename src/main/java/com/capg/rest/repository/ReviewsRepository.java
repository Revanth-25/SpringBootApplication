package com.capg.rest.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.capg.rest.entity.Reviews;

public interface ReviewsRepository extends JpaRepository<Reviews, Integer>
{
    Optional<Reviews> findByProductId(int productId);
}
