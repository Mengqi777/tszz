package com.heu.poet.tszz.websocket;


import com.google.gson.JsonArray;

public class ServerMsgPojo {
    private String from;
    private String type;
    private JsonArray data;

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }


    public JsonArray getData() {
        return data;
    }

    public void setData(JsonArray data) {
        this.data = data;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }


}
