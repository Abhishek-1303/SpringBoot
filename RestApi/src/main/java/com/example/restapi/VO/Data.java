package com.example.restapi.VO;

public class Data {
    private Body body;

    public Body getBody() {
        return body;
    }

    public void setBody(Body body) {
        this.body = body;
    }

    @Override
    public String toString() {
        return "Data{" +
                "body=" + body +
                '}';
    }
}
