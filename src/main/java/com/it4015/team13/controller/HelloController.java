package com.it4015.team13.controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
public class HelloController {

    @GetMapping("/")
    public ResponseEntity<String> Hello() {
        return ResponseEntity.ok("Hello team 13");
    }

}
