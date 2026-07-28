package com.tracking.application.dto;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
@JsonIgnoreProperties(ignoreUnknown = true)
public class NemotronResponse {
    private List<Choice> choices;

    @Setter
    @Getter
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Choice {
        private Message message;

    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Message {
        private String role;
        @Setter
        @Getter
        private String content;

    }
}
