package io.kronstadt.lab.pioneer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.reactive.function.client.WebClient;

@SpringBootApplication
public class PioneerApplication {

    public static void main(String[] args) {
        SpringApplication.run(PioneerApplication.class, args);
    }

    @Bean
    WebClient webClient(){
        return WebClient.builder().build();
    }
}
