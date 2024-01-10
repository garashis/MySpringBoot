package com.example.demo.repository;

import com.example.demo.dto.Customer;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface CustomerRepository extends CrudRepository<Customer, Integer> {

    //@Cacheable(value = "findByFirstName", unless="#result == null")
    @Cacheable(value = "user", key = "#username")
    Optional<Customer> findByUsername(String username);
    Optional<Customer> deleteByUsername(String username);

    //@Cacheable(value = "employee") Employee save(Employee employee);
    //@CacheEvict(value = "findByFirstName", key = "#employee.firstName")
    //@CachePut(value = "findByFirstName", key = "#result.firstName", condition = "#result != null")
    //Customer save(Customer customer);
}
