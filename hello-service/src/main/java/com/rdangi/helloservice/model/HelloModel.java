package com.rdangi.helloservice.model;

import lombok.Data;

/**
 * Created by ramdangi on 06/03/20.
 */
@Data
public class HelloModel {
    private final long id;
    private final String content;
    private final String dateTime;
}
