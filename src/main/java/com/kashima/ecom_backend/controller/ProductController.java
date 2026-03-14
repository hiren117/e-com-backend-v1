package com.kashima.ecom_backend.controller;


import com.kashima.ecom_backend.exception.ProductException;
import com.kashima.ecom_backend.model.Product;
import com.kashima.ecom_backend.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ProductController {

    @Autowired
    private ProductService productService;

    // localhost:1090/api/products?category=shirt&color=red&size=M....
    @GetMapping("/products")
    public ResponseEntity<Page<Product>> findProductByCategoryHandler(@RequestParam(required = false) String category,
                                                                      @RequestParam(required = false) List<String> colors,
                                                                      @RequestParam(required = false) List<String> sizes,
                                                                      @RequestParam(required = false) Integer minPrice,
                                                                      @RequestParam(required = false) Integer maxPrice,
                                                                      @RequestParam(required = false) Integer minDiscount,
                                                                      @RequestParam(required = false) String sort,
                                                                      @RequestParam(required = false) String stock,
                                                                      @RequestParam(defaultValue = "0") Integer pageNumber,
                                                                      @RequestParam(defaultValue = "10") Integer pageSize) throws ProductException {
        Page<Product> responsePage = productService.getAllProducts(category,colors,sizes,minPrice,maxPrice,
                minDiscount,sort,stock,pageNumber,pageSize);
        System.out.println("complete products list");
        return new ResponseEntity<>(responsePage, HttpStatus.ACCEPTED);
    }

    @GetMapping("/products/id/{productId}")
    public ResponseEntity<Product> findProductByIdHandler(@PathVariable Long productId) throws ProductException {
                                // get nu find kryu
        Product product = productService.findProductById(productId);

        return new ResponseEntity<>(product, HttpStatus.ACCEPTED);
    }
}
