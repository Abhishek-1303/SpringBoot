package com.example.restapi.VO;

public class Entities {

    private String type;
    private String name;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Entities{" +
                "type='" + type + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
