package com.rdangi.helloservice.controller;

import com.rdangi.helloservice.service.DateTimeService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.web.reactive.server.WebTestClient;
import org.springframework.web.reactive.config.EnableWebFlux;

public class HelloControllerTest {

    private WebTestClient client;

    @BeforeEach
    public void setUp() throws Exception {

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.register(WebConfig.class);
        context.refresh();

        client = WebTestClient.bindToApplicationContext(context).build();
    }

    @Test
    public void testDefaultGreeting() throws Exception {
        client.get().uri("/hello")
                .exchange()
                .expectStatus().isOk()
                .expectBody()
                .jsonPath("$.id").isEqualTo("1")
                .jsonPath("$.content").isEqualTo("Hello, World!")
                .jsonPath("$.dateTime").isEqualTo("Wed, Jan 01 2020 09:00:00");
    }

    @Test
    public void testGreetingWithParams() throws Exception {
        client.get().uri("/hello?name=John")
                .exchange()
                .expectStatus().isOk()
                .expectBody()
                .jsonPath("$.id").isEqualTo("1")
                .jsonPath("$.content").isEqualTo("Hello, John!")
                .jsonPath("$.dateTime").isEqualTo("Wed, Jan 01 2020 09:00:00");
    }


    @Configuration
    @EnableWebFlux
    static class WebConfig {

        @Bean
        public HelloController controller() {
            DateTimeService mockedDateTimeService = Mockito.mock(DateTimeService.class);
            Mockito.when(mockedDateTimeService.getCurrentDateTime()).thenReturn("Wed, Jan 01 2020 09:00:00");
            return new HelloController(mockedDateTimeService);
        }
    }

}
