package com.example.demo;

import com.example.demo.dto.Branch;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

@ConfigurationProperties(prefix = "rules")
@Configuration
public class Rules {
    private Map<String, Branch> branches = new HashMap<>();

    public Map<String, Branch> getBranches() {
        return branches;
    }

    public void setBranches(Map<String, Branch> branches) {
        this.branches = branches;
    }

}
