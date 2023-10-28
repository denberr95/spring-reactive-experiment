package com.web.reactive.model;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
@JsonInclude(Include.NON_EMPTY)
public class ErrorResponse {
    
    @JsonProperty
    private String msg;

    @JsonProperty
    private String sessionId;

    @JsonProperty
    private LocalDateTime timestamp;
}
