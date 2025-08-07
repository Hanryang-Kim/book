package com.example.demo.review.repository;

import com.example.demo.review.model.Review;
import org.springframework.data.jpa.repository.JpaRepository;

public interface reviewRepository extends JpaRepository<Review, Integer> {
}
