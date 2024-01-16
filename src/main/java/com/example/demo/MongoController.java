package com.example.demo;

import com.example.demo.dto.Customer;
import com.example.demo.repository.CustomerRepository;
import com.github.benmanes.caffeine.cache.Cache;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.caffeine.CaffeineCache;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;
import java.util.Optional;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR;
import static org.springframework.http.HttpStatus.NOT_FOUND;
import static org.springframework.http.HttpStatus.NO_CONTENT;
import static org.springframework.http.HttpStatus.OK;

@RestController
@AllArgsConstructor
@Slf4j
public class MongoController {

    private CustomerRepository customerRepository;

    @GetMapping("/user/{username}")
    @Cacheable(value = "getCustomerByUsername", key = "#username")
    Optional<Customer> getCustomerByUsername(@PathVariable String username) {
        log.info("getCustomerByUsername :: " + username);
        return customerRepository.findByUsername(username);
    }

    @PostMapping("/user")
    public ResponseEntity<Customer> createCustomer(@RequestBody Customer customer) {
        return new ResponseEntity(customerRepository.save(customer), CREATED);
    }

    @PutMapping("/user/{username}")
    public ResponseEntity<Customer> updateCustomer(@PathVariable("username") String username, @RequestBody Customer customer) {
        Optional<Customer> searchedCustomer = customerRepository.findByUsername(username);
        if (searchedCustomer.isPresent()) {
            Customer updatedCustomer = searchedCustomer.get();
            updatedCustomer.setName(customer.getName());
            updatedCustomer.setEmail(customer.getEmail());
            return new ResponseEntity<>(customerRepository.save(updatedCustomer), OK);
        } else {
            return new ResponseEntity<>(NOT_FOUND);
        }
    }

    @DeleteMapping("/user/{username}")
    public ResponseEntity<HttpStatus> deleteCustomer(@PathVariable("username") String username) {
        try {
            customerRepository.deleteByUsername(username);
            return new ResponseEntity<>(NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(INTERNAL_SERVER_ERROR);
        }
    }

    private final CacheManager cacheManager;

    @GetMapping(value = "/inspectCache")
    public void inspectCache(String cacheName) {

        CaffeineCache caffeineCache = (CaffeineCache) cacheManager.getCache(cacheName);
        Cache<Object, Object> nativeCache = caffeineCache.getNativeCache();

        for (Map.Entry<Object, Object> entry : nativeCache.asMap().entrySet()) {

            System.out.println("Key = " + entry.getKey());
            System.out.println("Value = " + entry.getValue());
        }
    }
}
