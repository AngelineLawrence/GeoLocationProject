package com.example.angelinealex.geolocationproject;

/**
 * Created by AngelineAlex on 8/9/17.
 */

public class MessageClass {

    private String message;
    private boolean seen;
    private long time;
    private String type;
    private String from;


    public MessageClass(){

    }

    public MessageClass(String message, boolean seen, long time, String type) {
        this.message = message;
        this.seen = seen;
        this.time = time;
        this.type = type;
    }


    public String getMessage() { return message; }

    public void setMessage(String message) { this.message = message; }

    public boolean getSeen() { return seen; }

    public void setSeen(boolean seen) { this.seen = seen; }

    public long getTime() { return time; }

    public void setTime(long time) { this.time = time; }

    public String getType() { return type; }

    public void setType(String type) { this.type = type; }

    public String getFrom() { return from; }

    public void setFrom(String from) { this.from = from; }

}
