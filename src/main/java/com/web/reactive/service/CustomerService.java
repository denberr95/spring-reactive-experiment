package com.web.reactive.service;

import com.web.reactive.model.Customer;
import com.web.reactive.repository.CustomerRepository;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class CustomerService {

    private final CustomerRepository customerRepository;

    public Mono<Customer> getById(Long id) {
        return customerRepository.findById(id);
    }

    public Mono<Customer> create(Customer customer) {
        return customerRepository.save(customer);
    }

    public Flux<Customer> getAll() {
        return customerRepository.findAll();
    }

    public Void deleteById(Long id) {
        return customerRepository.deleteById(id).block();
    }

    public Void deleteAll() {
        return customerRepository.deleteAll().block();
    }

    public Flux<Customer> getByLastName(String lastName) {
        return customerRepository.findByLastName(lastName);
    }
}
