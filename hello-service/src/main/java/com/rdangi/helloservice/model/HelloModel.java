package com.rdangi.helloservice.model;

/**
 * Created by ramdangi on 06/03/20.
 */
public class HelloModel {
    private final long id;
    private final String content;
    private final String dateTime;

    public HelloModel(long id, String content, String dateTime) {
        this.id = id;
        this.content = content;
        this.dateTime = dateTime;
    }

    public long getId() {
        return id;
    }

    public String getContent() {
        return content;
    }

    public String getDateTime() {
        return dateTime;
    }

}
