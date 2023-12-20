package com.example.demo;

import com.example.demo.dto.Branch;
import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

@ConfigurationProperties(prefix = "rules")
@Configuration
@Getter
@Setter
public class RulesConfig {
    private Map<String, Branch> branches = new HashMap<>();
}
