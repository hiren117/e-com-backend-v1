package com.kashima.ecom_backend.controller;

import com.kashima.ecom_backend.exception.ProductException;
import com.kashima.ecom_backend.exception.UserException;
import com.kashima.ecom_backend.model.Rating;
import com.kashima.ecom_backend.model.User;
import com.kashima.ecom_backend.repository.RatingRepository;
import com.kashima.ecom_backend.request.RatingRequest;
import com.kashima.ecom_backend.response.ApiResponse;
import com.kashima.ecom_backend.service.RatingService;
import com.kashima.ecom_backend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/ratings")
public class RatingController {

    @Autowired
    private RatingService ratingService;
    @Autowired
    private UserService userService;
    @Autowired
    private RatingRepository ratingRepository;

    @PostMapping("/create")
    public ResponseEntity<Rating> createRating(@RequestBody RatingRequest req,
                                                    @RequestHeader("Authorization") String jwt) throws ProductException, UserException {

        Rating rating = ratingService.createRating(req,userService.findUserProfileByJwt(jwt));

        return new ResponseEntity<>(rating, HttpStatus.CREATED);
    }
    @GetMapping("/product/{productId}")
    public ResponseEntity<List<Rating>> getProductRatings(@PathVariable("productId") Long productId,
                                                          @RequestHeader("Authorization") String jwt) throws ProductException, UserException {
        User user = userService.findUserProfileByJwt(jwt); // why kya hoga isse
        // haa agar user nahi hua to exception throw kr dega
        List<Rating> listOfRatings = ratingService.getProductRatings(productId);
        return new ResponseEntity<>(listOfRatings, HttpStatus.ACCEPTED);
    }
}
