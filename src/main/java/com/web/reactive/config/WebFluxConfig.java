package com.web.reactive.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.format.datetime.standard.DateTimeFormatterRegistrar;
import org.springframework.http.codec.ServerCodecConfigurer;
import org.springframework.web.reactive.config.WebFluxConfigurer;

import lombok.RequiredArgsConstructor;

@Configuration
@RequiredArgsConstructor
public class WebFluxConfig implements WebFluxConfigurer {

    private final CustomAppPropertiesConfig customAppPropertiesConfig;

    @Override
    public void configureHttpMessageCodecs(ServerCodecConfigurer serverCodecConfigurer) {
        serverCodecConfigurer
                .defaultCodecs()
                .maxInMemorySize(customAppPropertiesConfig.getHttpServer().getMaxInMemorySize());
        serverCodecConfigurer
                .defaultCodecs()
                .enableLoggingRequestDetails(customAppPropertiesConfig.getHttpServer().isEnableServerLog());
    }

    @Override
    public void addFormatters(FormatterRegistry registry) {
        DateTimeFormatterRegistrar dateTimeFormatterRegistrar = new DateTimeFormatterRegistrar();
        dateTimeFormatterRegistrar.setUseIsoFormat(true);
        dateTimeFormatterRegistrar.registerFormatters(registry);
    }
}