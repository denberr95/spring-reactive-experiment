package com.web.reactive.controller;

import java.time.LocalDateTime;

import com.web.reactive.model.ErrorResponse;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Mono;

@Slf4j
@RestControllerAdvice(basePackageClasses = CustomerController.class)
public class CustomerControllerAdvice {

    @ExceptionHandler(value = { Exception.class })
    public ResponseEntity<Mono<ErrorResponse>> handleException(Exception e) {
        log.error(e.getMessage(), e);
        ErrorResponse errorResponse = new ErrorResponse();
        errorResponse.setTimestamp(LocalDateTime.now());
        errorResponse.setMsg(e.getMessage());
        return ResponseEntity.internalServerError().body(Mono.just(errorResponse));
    }
}