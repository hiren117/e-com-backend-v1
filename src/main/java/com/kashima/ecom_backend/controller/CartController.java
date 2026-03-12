package com.kashima.ecom_backend.controller;

import com.kashima.ecom_backend.exception.CartItemException;
import com.kashima.ecom_backend.exception.ProductException;
import com.kashima.ecom_backend.exception.UserException;
import com.kashima.ecom_backend.model.Cart;
import com.kashima.ecom_backend.model.CartItem;
import com.kashima.ecom_backend.model.User;
import com.kashima.ecom_backend.request.AddItemRequest;
import com.kashima.ecom_backend.response.ApiResponse;
import com.kashima.ecom_backend.service.CartService;
import com.kashima.ecom_backend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/cart")
// @Tag(name = "cart Management", description = "find user cart , add item to cart" ) for documentation
public class CartController {

    @Autowired
    private CartService cartService;
    @Autowired
    private UserService userService;

    @PostMapping("/create")
    public ResponseEntity<ApiResponse> createCart(@RequestHeader("Authorization") String jwt) throws UserException, CartItemException {
        User user = userService.findUserProfileByJwt(jwt);
        cartService.createCart(user);
        ApiResponse apiResponse = new ApiResponse();
        apiResponse.setMessage("Cart created successfully");
        apiResponse.setStatus(true);
        return new ResponseEntity<>(apiResponse, HttpStatus.OK);
    }
    @GetMapping("/")
    // @Operation(description = "find cart by userid")
    public ResponseEntity<Cart> fidnUserCart(@RequestHeader("Authorization") String jwt) throws UserException {
        User user = userService.findUserProfileByJwt(jwt);
        Cart cart = cartService.findUserCart(user.getId());
        return new ResponseEntity<>(cart, HttpStatus.OK);
    }

    @PutMapping("/add")
    // @Operation(description = "add item to cart")
    public ResponseEntity<ApiResponse> addCartItem(@RequestBody AddItemRequest req, @RequestHeader("Authorization") String jwt) throws UserException, ProductException {
        User user = userService.findUserProfileByJwt(jwt);
        cartService.addCartItem(user.getId(),req);
        ApiResponse response = new ApiResponse();
        response.setMessage("item added to cart you did it bro");
        response.setStatus(true);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
