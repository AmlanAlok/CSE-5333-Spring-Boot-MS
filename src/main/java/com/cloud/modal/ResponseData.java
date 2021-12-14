package com.cloud.modal;

import org.json.simple.JSONObject;

public class ResponseData {

    private String message = "";
    private String error = "";
    private JSONObject data;

    public ResponseData(String message, JSONObject data) {
        this.message = message;
        this.data = data;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setData(JSONObject data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "ResponseData{" +
                "message='" + message + '\'' +
                ", data=" + data +
                '}';
    }
}
