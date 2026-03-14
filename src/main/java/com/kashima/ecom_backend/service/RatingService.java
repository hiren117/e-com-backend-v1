package com.kashima.ecom_backend.service;

import com.kashima.ecom_backend.exception.ProductException;
import com.kashima.ecom_backend.model.Product;
import com.kashima.ecom_backend.model.Rating;
import com.kashima.ecom_backend.model.User;
import com.kashima.ecom_backend.request.RatingRequest;

import java.util.List;

public interface RatingService  {
    public Rating createRating(RatingRequest req, User user) throws ProductException; // for rating any product that product has to be there
                                                                                        // so productException
    public List<Rating> getProductRatings(Long productId) throws ProductException;
}
