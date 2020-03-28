package com.rdangi.gateway.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FallbackController {

    @GetMapping("/gateway-fallback")
    public String fallback(){
        return "Message is from the Fallback controller";
    }
}
