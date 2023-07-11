package com.example.demo;

import org.springframework.stereotype.Service;

@Service
public class AppService {

    public Greeting sum(AppDTO appDTO){
        return new Greeting(appDTO.getFName() + " " + appDTO.getLName());
    }
}
