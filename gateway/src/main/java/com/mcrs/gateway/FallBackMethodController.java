package com.mcrs.gateway;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FallBackMethodController {
    @GetMapping("/userServiceFallback")
    public String UsersFallBackMethod() {
        return "Users Service is taking longer than Expected. Please try again later";
    }

    @GetMapping("/departmentServiceFallback")
    public String DepartmentFallBackMethod() {
        return "Department Service is taking longer than Expected. Please try again later";
    }
}
