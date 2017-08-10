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


    /**
     * Instantiates a new Message class.
     */
    public MessageClass(){

    }

    /**
     * Instantiates a new Message class.
     *
     * @param message the message
     * @param seen    the seen
     * @param time    the time
     * @param type    the type
     */
    public MessageClass(String message, boolean seen, long time, String type) {
        this.message = message;
        this.seen = seen;
        this.time = time;
        this.type = type;
    }


    /**
     * Gets message.
     *
     * @return the message
     */
    public String getMessage() { return message; }

    /**
     * Sets message.
     *
     * @param message the message
     */
    public void setMessage(String message) { this.message = message; }

    /**
     * Gets seen.
     *
     * @return the seen
     */
    public boolean getSeen() { return seen; }

    /**
     * Sets seen.
     *
     * @param seen the seen
     */
    public void setSeen(boolean seen) { this.seen = seen; }

    /**
     * Gets time.
     *
     * @return the time
     */
    public long getTime() { return time; }

    /**
     * Sets time.
     *
     * @param time the time
     */
    public void setTime(long time) { this.time = time; }

    /**
     * Gets type.
     *
     * @return the type
     */
    public String getType() { return type; }

    /**
     * Sets type.
     *
     * @param type the type
     */
    public void setType(String type) { this.type = type; }

    /**
     * Gets from.
     *
     * @return the from
     */
    public String getFrom() { return from; }

    /**
     * Sets from.
     *
     * @param from the from
     */
    public void setFrom(String from) { this.from = from; }

}
