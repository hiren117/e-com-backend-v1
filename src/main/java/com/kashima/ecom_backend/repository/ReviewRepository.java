package com.kashima.ecom_backend.repository;

import com.kashima.ecom_backend.model.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ReviewRepository extends JpaRepository<Review,Long> {

    @Query("SELECT r FROM Review r WHERE r.product.id = :productId")
    public List<Review> getALlReviewsByProductId(@Param("productId") Long productId);
}
