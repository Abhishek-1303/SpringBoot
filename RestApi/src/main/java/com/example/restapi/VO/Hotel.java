package com.example.restapi.VO;

public class Hotel {

    private String result;
    private Data data;

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public Data getData() {
        return data;
    }

    public void setData(Data data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "Hotel{" +
                "result='" + result + '\'' +
                ", data=" + data +
                '}';
    }
}
