package com.rdangi.helloservice.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.rdangi.helloservice.model.HelloModel;
import com.rdangi.helloservice.service.DateTimeService;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicLong;

/**
 * Created by ramdangi on 06/03/20.
 */
@RestController
@Slf4j
public class HelloController {

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    private DateTimeService dateTimeService;

    private String role;

    @Autowired
    public HelloController(DateTimeService dateTimeService, @Value("${role}") String role) {
        this.dateTimeService = dateTimeService;
        this.role = role;
    }

    @GetMapping("/hello")
    @HystrixCommand(fallbackMethod = "getFallbackHelloModel")
    public HelloModel greeting(@RequestParam(value = "name", defaultValue = "World") String name) {
        if ("testFallback".equals(name)) {
            // to test the fallback functionality
            // throws a Runtime exception when the testFallback param is received
            // However this won't fail the web service call.
            // Due to hystrix configuration, the getFallbackHelloModel will be invoked and returns the response
            log.error("Fallback condition is matched, so an exception will be thrown");
            throw new RuntimeException();
        }

        return generateHelloModel(name);
    }

    private HelloModel generateHelloModel(String name) {
        log.info("Generating greeting message");
        HelloModel helloModel = HelloModel.builder()
            .id(counter.incrementAndGet())
            .content(String.format(template, name))
            .dateTime(dateTimeService.getCurrentDateTime())
            .currentDate(dateTimeService.getCurrentDate())
            .role(role)
            .build();
        log.info("Generated the greeting message, {}", helloModel);
        return helloModel;
    }

    public HelloModel getFallbackHelloModel(String name) {
        log.info("Generating greeting message for fallback");
        HelloModel helloModel = HelloModel.builder()
            .id(counter.incrementAndGet())
            .content(String.format(template, "Fallback user"))
            .dateTime(dateTimeService.getCurrentDateTime())
            .currentDate(dateTimeService.getCurrentDate())
            .role("fallback role")
            .build();
        log.info("Generated the greeting message, {}", helloModel);
        return helloModel;
    }
}
