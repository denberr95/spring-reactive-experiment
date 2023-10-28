package com.web.reactive.repository;

import com.web.reactive.model.Customer;

import org.springframework.data.r2dbc.repository.Query;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

import reactor.core.publisher.Flux;

public interface CustomerRepository extends ReactiveCrudRepository<Customer, Long> {

    @Query("SELECT c.* FROM customer c WHERE last_name = :lastName")
    Flux<Customer> findByLastName(String lastName);
}