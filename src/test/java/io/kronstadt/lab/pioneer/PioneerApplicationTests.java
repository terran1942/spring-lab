package io.kronstadt.lab.pioneer;

import io.kronstadt.lab.pioneer.model.Customer;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.util.UriComponentsBuilder;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;

@SpringBootTest
class PioneerApplicationTests {
    @Autowired
    private WebClient webClient;

    @Test
    void contextLoads() {
        this.webClient.get()
                .uri(UriComponentsBuilder.newInstance()
                        .scheme("http")
                        .host("localhost")
                        .port(8080)
                        .path("/customer")
//                        .pathSegment("a", "b")
//                        .query("sex={sex}")
                        .queryParam("username", "terran")
                        .queryParam("password", "123456")
//                        .fragment("eve")
                        .encode(StandardCharsets.UTF_8)
//                        .buildAndExpand("男")
                        .build()
                        .toUri())
                .accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .bodyToMono(Customer.class)
                .doOnSuccess(System.out::println)
//                .flatMap(customer -> {return new String("atx")}).flatMap(s->{s})
                .subscribe();

//		this.webClient.post().body().retrieve().bodyToMono().subscribe()
    }

    @Test
    void uriBuilderTest() {
        String uri = UriComponentsBuilder.newInstance()
                .scheme("http")
                .host("localhost")
                .port(8080)
                .path("/customer")
                .pathSegment("a", "b")
                .query("sex={sex}")
                .queryParam("username", "terran")
                .queryParam("password", "987654321")
                .fragment("eve")
                .encode(StandardCharsets.UTF_8)
                .buildAndExpand("男").toUriString();
        System.out.println(uri);
    }

}
