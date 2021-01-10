package com.example.security.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/public")
public class SecurityController {

    @GetMapping("/api1")
    public String Api1() {
        return "TEST API 1";
    }

    @GetMapping("/api2")
    public String Api2() {
        return "TEST API 2";
    }

    @GetMapping("/api3")
    public String Api3() {
        return "TEST API 3";
    }

    @GetMapping("/api4")
    public String Api4() {
        return "TEST API 4";
    }
}
