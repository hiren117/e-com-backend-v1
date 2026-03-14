package com.kashima.ecom_backend.service;

import com.kashima.ecom_backend.exception.ProductException;
import com.kashima.ecom_backend.model.Review;
import com.kashima.ecom_backend.model.User;
import com.kashima.ecom_backend.repository.ReviewRepository;
import com.kashima.ecom_backend.request.ReviewRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
@Service
public class ReviewServiceImpl implements ReviewService {

    @Autowired
    private ReviewRepository reviewRepository;
    @Autowired
    private ProductService productService;

    @Override
    public Review createReview(ReviewRequest req, User user) throws ProductException {
        Review review = new Review(); // id, user, product, review
        review.setUser(user);
        review.setProduct(productService.findProductById(req.getProductId()));
        review.setReview(req.getReview());
        review.setCreatedAt(LocalDateTime.now());
        return reviewRepository.save(review);
    }

    @Override
    public List<Review> getProductReviews(Long productId) throws ProductException {
        return reviewRepository.getALlReviewsByProductId(productId);
    }
}
