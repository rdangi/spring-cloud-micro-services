package com.rdangi.helloservice.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Created by ramdangi on 06/03/20.
 */
@Service
public class DateTimeService {

    private Logger log = LoggerFactory.getLogger(this.getClass());

    public String getCurrentDateTime() {
        log.info("Getting current date and time");
        LocalDateTime myDateObj = LocalDateTime.now();
        DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("E, MMM dd yyyy HH:mm:ss");
        return myDateObj.format(myFormatObj);
    }

    // This is just for redis cache example only
    // Does not make sense in realtime scenario to cache the current date
    // TODO : Add a better example to demonstrate this
    @Cacheable(value = "currentDate")
    public String getCurrentDate() {
        log.info("Getting current date");
        LocalDateTime myDateObj = LocalDateTime.now();
        DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd-MM-YYYY");
        return myDateObj.format(myFormatObj);
    }

}
