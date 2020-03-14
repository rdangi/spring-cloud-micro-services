package com.rdangi.helloservice.controller;

import com.rdangi.helloservice.model.HelloModel;
import com.rdangi.helloservice.service.DateTimeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicLong;

/**
 * Created by ramdangi on 06/03/20.
 */
@RestController
public class HelloController {
    private static final Logger LOGGER = LoggerFactory.getLogger(HelloController.class);

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    private DateTimeService dateTimeService;

    @Autowired
    public HelloController(DateTimeService dateTimeService) {
        this.dateTimeService = dateTimeService;
    }

    @GetMapping("/hello")
    public HelloModel greeting(@RequestParam(value = "name", defaultValue = "World") String name) {
        return new HelloModel(counter.incrementAndGet(), String.format(template, name), dateTimeService.getCurrentDateTime());
    }

}
