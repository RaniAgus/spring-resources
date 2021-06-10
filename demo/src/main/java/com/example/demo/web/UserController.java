package com.example.demo.web;

import com.example.demo.domain.Product;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @RequestMapping("/{userId}")
    public String displayUser(@PathVariable int userId) {
        return "User found: " + userId;
    }

    @RequestMapping("/{id}/invoices")
    public String displayUserInvoices(
            @PathVariable(value = "id")
                    int userId,
            @RequestParam(value = "d", required = false)
            @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) // yyyy-mm-dd
                    LocalDate date
    ) {
        return "Invoice found for the user " + userId + " dated " +
                (date != null ? date.toString() : LocalDate.now().toString());
    }

    @RequestMapping("{userId}/items")
    public List<String> getUserItems(@PathVariable int userId) {
        return Arrays.asList("shoes", "laptop", "button");
    }

    @RequestMapping("{userId}/products")
    public List<Product> getProductsAsJson(@PathVariable int userId) {
        return Arrays.asList(
                new Product(1, "shoes", 42.99),
                new Product(2, "laptop", 599.99),
                new Product(3, "button", 1.99)
        );
    }
}
