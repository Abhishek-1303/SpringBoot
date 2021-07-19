package com.example.restapi.VO;

public class Entities {

    private long destinationId;

    public long getDestinationId() {
        return destinationId;
    }

    public void setDestinationId(long destinationId) {
        this.destinationId = destinationId;
    }

    @Override
    public String toString() {
        return "Entities{" +
                "destinationId=" + destinationId +
                '}';
    }
}
