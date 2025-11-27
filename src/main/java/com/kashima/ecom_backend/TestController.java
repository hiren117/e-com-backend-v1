package com.kashima.ecom_backend;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @GetMapping("/test")
    public String test() {
        return "Backend Working ✅ yo bhai tu fad dega isbaar ";
    }
}
