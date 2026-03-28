package com.kashima.ecom_backend.controller;

import com.kashima.ecom_backend.response.ApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

    @GetMapping("/")
    public ResponseEntity<ApiResponse> homeController(){
        ApiResponse response = new ApiResponse("Welcom to Kasima",true);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
