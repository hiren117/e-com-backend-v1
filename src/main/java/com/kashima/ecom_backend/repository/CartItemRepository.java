package com.kashima.ecom_backend.repository;

import com.kashima.ecom_backend.model.Cart;
import com.kashima.ecom_backend.model.CartItem;
import com.kashima.ecom_backend.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface CartItemRepository extends JpaRepository<CartItem,Long> {

    @Query("SELECT ci FROM CartItem ci Where ci.cart=:cart AND ci.size=:size AND ci.product=:product AND ci.userId=:userId")
    public CartItem isCartItemExist(@Param("cart") Cart cart,
                                    @Param("product") Product product,
                                    @Param("size") String size,
                                    @Param("userId") Long userId);


}
