package com.kashima.ecom_backend.controller;

import com.kashima.ecom_backend.exception.ProductException;
import com.kashima.ecom_backend.exception.UserException;
import com.kashima.ecom_backend.model.Review;
import com.kashima.ecom_backend.model.User;
import com.kashima.ecom_backend.request.ReviewRequest;
import com.kashima.ecom_backend.service.ReviewService;
import com.kashima.ecom_backend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/reviews")
public class ReviewController {

    @Autowired
    private ReviewService reviewService;
    @Autowired
    private UserService userService;

    @PostMapping("/create")
    public ResponseEntity<Review> createReview(@RequestBody ReviewRequest req,
                                               @RequestHeader("Authorization") String jwt) throws ProductException, UserException {
        Review review = reviewService.createReview(req,userService.findUserProfileByJwt(jwt));
        return new ResponseEntity<>(review, HttpStatus.CREATED);
    };
    @GetMapping("/product/{productId}")
    public ResponseEntity<List<Review>> getProductReviews(@PathVariable("productId") Long productId,
                                                          @RequestHeader("Authorization") String jwt) throws ProductException, UserException {
        // not sure about this do we need this user authorization or not ?
        User user = userService.findUserProfileByJwt(jwt);

        List<Review> listOfReviews = reviewService.getProductReviews(productId);
        return new ResponseEntity<>(listOfReviews, HttpStatus.ACCEPTED);
    };
}
