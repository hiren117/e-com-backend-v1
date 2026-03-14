package com.kashima.ecom_backend.repository;

import com.kashima.ecom_backend.model.Rating;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface RatingRepository extends JpaRepository<Rating,Long> {

    @Query("SELECT r FROM Rating r WHERE r.product.id = :productId") // rating -- > id,user,product,rating
    // i have to find r.product.id ---> rating in that product and uski id
    public List<Rating> getAllRatingsByProductId(@Param("productId") Long productId);

}
