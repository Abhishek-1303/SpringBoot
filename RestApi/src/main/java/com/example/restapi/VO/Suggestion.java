package com.example.restapi.VO;

import java.util.List;

public class Suggestion {

    private List<Entities> entities;

    public List<Entities> getEntities() {
        return entities;
    }

    public void setEntities(List<Entities> entities) {
        this.entities = entities;
    }

    @Override
    public String toString() {
        return "Suggestion{" +
                "entities=" + entities +
                '}';
    }
}
