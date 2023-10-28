package com.web.reactive.config;

import java.time.format.DateTimeFormatter;

import com.web.reactive.util.Constants;

import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.format.datetime.DateFormatter;
import org.springframework.format.datetime.DateFormatterRegistrar;
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
        dateTimeFormatterRegistrar.setDateFormatter(DateTimeFormatter.ofPattern(Constants.DATE_FORMAT_1));
        dateTimeFormatterRegistrar.setDateTimeFormatter(DateTimeFormatter.ofPattern(Constants.DATE_TIME_FORMAT_1));
        dateTimeFormatterRegistrar.registerFormatters(registry);

        DateFormatterRegistrar dateFormatterRegistrar = new DateFormatterRegistrar();
        dateFormatterRegistrar.setFormatter(new DateFormatter(Constants.DATE_FORMAT_1));
        dateFormatterRegistrar.registerFormatters(registry);
    }
}
