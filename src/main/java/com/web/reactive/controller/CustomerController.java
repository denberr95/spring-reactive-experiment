package com.web.reactive.controller;

import com.web.reactive.model.Customer;
import com.web.reactive.service.CustomerService;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RequestMapping("/customers")
@RestController
@RequiredArgsConstructor
public class CustomerController {

    private final CustomerService customerService;

    @GetMapping
    public ResponseEntity<Flux<Customer>> getAll() {
        return ResponseEntity.ok().body(customerService.getAll());
    }

    @PostMapping
    public ResponseEntity<Mono<Customer>> create(@RequestBody Customer customer) {
        return ResponseEntity.ok().body(customerService.create(customer));
    }

    @DeleteMapping
    public ResponseEntity<Mono<Void>> deleteAll() {
        customerService.deleteAll();
        return ResponseEntity.noContent().build();
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<Mono<Customer>> getById(@PathVariable Long id) {
        return ResponseEntity.ok().body(customerService.getById(id));
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Mono<Void>> deleteById(@PathVariable Long id) {
        customerService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping(path = "/lastName/{lastName}")
    public ResponseEntity<Flux<Customer>> getByLastName(@PathVariable String lastName) {
        return ResponseEntity.ok().body(customerService.getByLastName(lastName));
    }
}
