package com.example.restapi.VO;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Location {
    private List<Suggestion> suggestions;

    public List<Suggestion> getSuggestions() {
        return suggestions;
    }

    public void setSuggestions(List<Suggestion> suggestions) {
        this.suggestions = suggestions;
    }

    @Override
    public String toString() {
        return "Hotel{" +
                "suggestions=" + suggestions +
                '}';
    }
}
