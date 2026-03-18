package com.kashima.ecom_backend.controller;

import com.kashima.ecom_backend.exception.CartItemException;
import com.kashima.ecom_backend.exception.UserException;
import com.kashima.ecom_backend.model.CartItem;
import com.kashima.ecom_backend.model.User;
import com.kashima.ecom_backend.response.ApiResponse;
import com.kashima.ecom_backend.service.CartItemService;
import com.kashima.ecom_backend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/cart_items")
public class CartItemController {
    @Autowired
    private CartItemService cartItemService;

    @Autowired
    private UserService userService;



    @DeleteMapping("/{cartItemId}")
    public ResponseEntity<ApiResponse> deleteCartItem(@PathVariable Long cartItemId,
                                                      @RequestHeader ("Authorization") String jwt) throws UserException, CartItemException {
        User user = userService.findUserProfileByJwt(jwt);
        cartItemService.removeCartItem(user.getId(),cartItemId);
        ApiResponse response = new ApiResponse();
        response.setMessage("item deleted from cart");
        response.setStatus(true);

        return new ResponseEntity<>(response, HttpStatus.OK);

    }

    @PutMapping("/{cartItemId}")
    public ResponseEntity<ApiResponse> updateCartItem(@PathVariable Long cartItemId,
                                                      @RequestBody CartItem cartItem,
                                                      @RequestHeader ("Authorization") String jwt) throws UserException, CartItemException {
        User user = userService.findUserProfileByJwt(jwt);
        cartItemService.updateCartItem(user.getId(),cartItemId,cartItem);
        ApiResponse response = new ApiResponse();
        response.setMessage("item updated from cart");
        response.setStatus(true);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }


}

