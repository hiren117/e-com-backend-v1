package com.kashima.ecom_backend.service;

import com.kashima.ecom_backend.exception.ProductException;
import com.kashima.ecom_backend.model.Review;
import com.kashima.ecom_backend.model.User;
import com.kashima.ecom_backend.request.ReviewRequest;

import java.util.List;

public interface ReviewService {
    public Review createReview(ReviewRequest req, User user) throws ProductException;

    public List<Review> getProductReviews(Long productId) throws ProductException;
}
