package com.rdangi.gateway;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.contract.wiremock.AutoConfigureWireMock;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.reactive.server.WebTestClient;

import static com.github.tomakehurst.wiremock.client.WireMock.*;

@ExtendWith(SpringExtension.class)
@SpringBootTest(
        webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT,
        properties = {"gateway.target.url.hello-service=http://localhost:${wiremock.server.port}"})
@AutoConfigureWireMock(port = 0)
public class GatewayApplicationTest {

    @Autowired
    private WebTestClient webClient;

    @Test
    public void testGatewayService() throws Exception {
        stubFor(get(urlEqualTo("/hello"))
                .willReturn(aResponse()
                        .withBody("{\"content\":\"Hello World!\"}")
                        .withHeader("Content-Type", "application/json")));

        stubFor(get(urlEqualTo("/hello?name=John"))
                .willReturn(aResponse()
                        .withBody("{\"content\":\"Hello John!\"}")
                        .withHeader("Content-Type", "application/json")));

        webClient.get().uri("/hello")
                .exchange()
                .expectStatus().isOk()
                .expectBody()
                .jsonPath("$.content").isEqualTo("Hello World!");

        webClient.get().uri("/hello?name=John")
                .exchange()
                .expectStatus().isOk()
                .expectBody()
                .jsonPath("$.content").isEqualTo("Hello John!");
    }

}