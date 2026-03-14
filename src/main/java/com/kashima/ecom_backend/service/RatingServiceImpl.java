package com.kashima.ecom_backend.service;

import com.kashima.ecom_backend.exception.ProductException;
import com.kashima.ecom_backend.model.Product;
import com.kashima.ecom_backend.model.Rating;
import com.kashima.ecom_backend.model.User;
import com.kashima.ecom_backend.repository.RatingRepository;
import com.kashima.ecom_backend.request.RatingRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class RatingServiceImpl implements RatingService {

    @Autowired
    private RatingRepository ratingRepository;
    @Autowired
    private ProductService productService;


    @Override
    public Rating createRating(RatingRequest req, User user) throws ProductException {
        Rating rating = new Rating(); // id, user, product, rating
        rating.setUser(user);
        rating.setProduct(productService.findProductById(req.getProductId()));
        rating.setRating(req.getRating());
        rating.setCreatedAt(LocalDateTime.now());

        return ratingRepository.save(rating);
    }

    @Override
    public List<Rating> getProductRatings(Long productId) throws ProductException {
        // here i have to find all rating which has given productId
        // meaning from where do i find all these rating
        //Obviously form repository which ratingRepository
        // so have to write one method in ratingRepository

        return ratingRepository.getAllRatingsByProductId(productId);
    }
}
