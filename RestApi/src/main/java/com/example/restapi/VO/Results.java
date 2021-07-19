package com.example.restapi.VO;

public class Results {
    private String name;
    private Double starRating;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getStarRating() {
        return starRating;
    }

    public void setStarRating(Double starRating) {
        this.starRating = starRating;
    }

    @Override
    public String toString() {
        return "Results{" +
                "name='" + name + '\'' +
                ", starRating=" + starRating +
                '}';
    }
}
