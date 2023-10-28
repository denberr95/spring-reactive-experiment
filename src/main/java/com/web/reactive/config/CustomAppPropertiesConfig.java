package com.web.reactive.config;

import jakarta.annotation.PostConstruct;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

@Data
@Slf4j
@Configuration
@ConfigurationProperties(prefix = "custom-config")
public class CustomAppPropertiesConfig {

    private HttpServer httpServer;

    @Data
    @ConfigurationProperties(prefix = "http-server")
    static class HttpServer {

        private boolean enableServerLog = false;

        private int maxInMemorySize = -1;
    }

    @PostConstruct
    private void init() {
        log.debug("Loaded custom application properties: '{}'", this.toString());
    }
}