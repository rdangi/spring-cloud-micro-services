package com.rdangi.helloservice.model;

import lombok.Builder;
import lombok.Data;

/**
 * Created by ramdangi on 06/03/20.
 */
@Data
@Builder
public class HelloModel {
    private final long id;
    private final String content;
    private final String dateTime;
    private final String currentDate;
    private final String role;
}
