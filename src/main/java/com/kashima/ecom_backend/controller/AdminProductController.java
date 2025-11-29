package com.kashima.ecom_backend.controller;

import com.kashima.ecom_backend.exception.ProductException;
import com.kashima.ecom_backend.model.Product;
import com.kashima.ecom_backend.request.CreateProductRequest;
import com.kashima.ecom_backend.response.ApiResponse;
import com.kashima.ecom_backend.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/admin/products")
public class AdminProductController {

    @Autowired
    private ProductService productService;

    @PostMapping("/")
    public ResponseEntity<Product> createProduct(@RequestBody CreateProductRequest req) throws ProductException {
        Product product = productService.createProduct(req);
        System.out.println("product = " + product);
        return new ResponseEntity<Product>(product, HttpStatus.CREATED);
    }
    @DeleteMapping("/{productId}/delete")
    public ResponseEntity<ApiResponse> deleteProduct(@PathVariable Long productId) throws ProductException {
//        String result = productService.deleteProduct(productId);
//        return new ResponseEntity<>(result, HttpStatus.OK);
        productService.deleteProduct(productId);
        ApiResponse res = new ApiResponse();
        res.setMessage("Product deleted successfully");
        res.setStatus(true);

        return new ResponseEntity<>(res, HttpStatus.OK);

    }
    @GetMapping("/all")
    public ResponseEntity<List<Product>> findAllProducts() throws ProductException {
        List<Product> products = productService.findAllProducts();
        return new ResponseEntity<>(products, HttpStatus.OK);
    }
    @PutMapping("/{productId}/update")
    public ResponseEntity<Product> updateProduct(@PathVariable Long productId,@RequestBody Product req) throws ProductException {
        Product updatedProduct =  productService.updateProduct(productId, req);

        return new ResponseEntity<>(updatedProduct, HttpStatus.CREATED);
    }

    // how to create multiple product for new application
    @PostMapping("/create")
    public ResponseEntity<ApiResponse> createMultipleProducts(@RequestBody CreateProductRequest[] req) throws ProductException {
        for(int j=0;j<req.length;j++){
            productService.createProduct(req[j]);
        }
        ApiResponse res = new ApiResponse();
        res.setMessage("Total "+ req.length + " Products created successfully");
        res.setStatus(true);
        return new ResponseEntity<>(res, HttpStatus.CREATED);
    }

}
