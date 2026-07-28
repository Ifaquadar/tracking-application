package com.tracking.application.service;

import com.tracking.application.dto.NemotronResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.List;
import java.util.Map;

@Service
public class NemotronService {

    private final WebClient webClient;

    @Value("${nvidia.api.key}")
    private String apiKey;

    @Value("${nvidia.api.model}")
    private String model;

    public NemotronService(WebClient nemotronWebClient) {
        this.webClient = nemotronWebClient;
    }

    public String getCompletion(String prompt) {
        System.out.println("apiKey"+apiKey);
        Map<String, Object> body = Map.of(
                "model", model,
                "messages", List.of(Map.of("role", "user", "content", prompt)),
                "temperature", 1,
                "top_p", 0.95,
                "max_tokens", 1024
        );

        NemotronResponse response = webClient.post()
                .uri("/chat/completions")
                .header("Authorization", "Bearer " + apiKey)
                .contentType(MediaType.APPLICATION_JSON)
                .bodyValue(body)
                .retrieve()
                .bodyToMono(NemotronResponse.class)
                .block();

        if (response == null || response.getChoices() == null || response.getChoices().isEmpty()) {
            return "No response from model.";
        }

        return response.getChoices().get(0).getMessage().getContent();
    }
}
