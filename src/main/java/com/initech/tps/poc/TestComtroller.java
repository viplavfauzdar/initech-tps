package com.initech.tps.poc;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class TestComtroller {

    @GetMapping("/test")
    public String test(){
        return "Welcome to Initech!";
    }
}
