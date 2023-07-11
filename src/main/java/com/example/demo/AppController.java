package com.example.demo;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.*;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@RestController
public class AppController {
    private final AppService appService;

    public AppController(AppService appService) {
        this.appService = appService;
    }

    @RequestMapping("/")
    public String hello() {
        return "Hello Spring Boot world.";
    }

    @GetMapping("/formatDate")
    public String date(@RequestParam @Validated @DateTimeFormat(pattern = "yyyy-MM-dd") Date date) {
        throw new NoRecordFoundException("some error");
        //return "Hello Spring Boot world.";
    }

    @PostMapping("/create")
    public ResponseEntity<Greeting> create(@RequestBody AppDTO dto) {
        return new ResponseEntity<>(appService.sum(dto), HttpStatus.FOUND);
    }
}
