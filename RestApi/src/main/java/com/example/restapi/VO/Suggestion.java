package com.example.restapi.VO;

import java.util.List;

public class Suggestion {
    private String group;
    private List<Entities> entities;

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public List<Entities> getEntities() {
        return entities;
    }

    public void setEntities(List<Entities> entities) {
        this.entities = entities;
    }

    @Override
    public String toString() {
        return "Suggestion{" +
                "group='" + group + '\'' +
                ", entities=" + entities +
                '}';
    }
}
