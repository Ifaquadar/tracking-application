package com.tracking.application.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class NemotronConfig {
    @Value("${nvidia.api.base-url}")
    private String baseUrl;

    @Bean
    public WebClient nemotronWebClient() {
        return WebClient.builder()
                .baseUrl(baseUrl)
                .build();
    }
}
