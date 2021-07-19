package com.example.restapi.VO;

import java.util.List;

public class SearchResult {
    private List<Results> results;

    public List<Results> getResults() {
        return results;
    }

    public void setResults(List<Results> results) {
        this.results = results;
    }

    @Override
    public String toString() {
        return "SearchResult{" +
                "results=" + results +
                '}';
    }
}
