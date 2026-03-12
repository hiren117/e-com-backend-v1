package com.kashima.ecom_backend.service;

import com.kashima.ecom_backend.exception.ProductException;
import com.kashima.ecom_backend.model.Cart;
import com.kashima.ecom_backend.model.CartItem;
import com.kashima.ecom_backend.model.Product;
import com.kashima.ecom_backend.model.User;
import com.kashima.ecom_backend.repository.CartItemRepository;
import com.kashima.ecom_backend.repository.CartRepository;
import com.kashima.ecom_backend.request.AddItemRequest;
import org.springframework.stereotype.Service;

@Service
public class CartServiceImpl implements CartService {

    private CartRepository cartRepository;
    private CartItemService cartItemService;
    private ProductService productService;
    private CartItemRepository cartItemRepository;

    public CartServiceImpl(CartRepository cartRepository, CartItemService cartItemService, ProductService productService, CartItemRepository cartItemRepository) {
        this.cartRepository = cartRepository;
        this.cartItemService = cartItemService;
        this.productService = productService;
        this.cartItemRepository = cartItemRepository;
    }

    @Override
    public Cart createCart(User user) {
        Cart cart = new Cart();
        cart.setUser(user);
        cartRepository.save(cart);
        return cart;
    }

    @Override
    public String addCartItem(Long userId, AddItemRequest req) throws ProductException {
        Cart cart = cartRepository.findByUserId(userId);
        Product product = productService.findProductById(req.getProductId());

        CartItem isPresent = cartItemService.isCartItemExist(cart,product,req.getSize(),userId);

        if(isPresent==null){
           // isPresent.setQuantity(isPresent.getQuantity()+req.getQuantity()); what to do if it is already present
           // isPresent.setPrice(product.getPrice());
            CartItem cartItem = new CartItem();
            cartItem.setUserId(userId);
            cartItem.setProduct(product);
            cartItem.setQuantity(req.getQuantity());
            cartItem.setPrice(req.getQuantity()*product.getDiscountedPrice());
            cartItem.setCart(cart);
            cartItem.setSize(req.getSize());

            CartItem createdCartItem = cartItemService.createCartItem(cartItem);
            cart.getCartItems().add(createdCartItem);
        }else{
            // if item already exist in cart
            isPresent.setQuantity(isPresent.getQuantity() + req.getQuantity());
            isPresent.setPrice(isPresent.getPrice() + req.getQuantity()*product.getDiscountedPrice());

            cartItemRepository.save(isPresent);
        }

        return "Item added successfully";
    }

    @Override
    public Cart findUserCart(Long userId) {
        Cart cart = cartRepository.findByUserId(userId);

        int totalPrice = 0;
        int totalDiscountedPrice = 0;
        int totalItem = 0;

        for(CartItem cartItem : cart.getCartItems()){
            totalPrice+= cartItem.getPrice();
            totalDiscountedPrice+= cartItem.getDiscountedPrice();
            totalItem +=  cartItem.getQuantity();
        }
        cart.setTotalPrice(totalPrice);
        cart.setTotalDiscountedPrice(totalDiscountedPrice);
        cart.setTotalItem(totalItem);
        cart.setDiscount(totalPrice - totalDiscountedPrice);

        cartRepository.save(cart);
        return cart;
    }
}
