package com.example.demo.web;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.Date;

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


}
