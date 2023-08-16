package com.harpia.stive;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.client.WebClient;

@SpringBootApplication
public class ApiTransparenciaGovBrApplication {

    public static void main(String[] args) {
        SpringApplication.run(ApiTransparenciaGovBrApplication.class, args);
    }

    @Bean
    public WebClient webClientPortalTransparencia(WebClient.Builder builder) {
        return builder
                .baseUrl("https://portaldatransparencia.gov.br")
                .defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .build();
    }

    @Bean
    public WebClient webClientApiDados(WebClient.Builder builder) {
        return builder
                .baseUrl("https://api.portaldatransparencia.gov.br/api-de-dados")
                .defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE, "chave-api-dados", "91fdd26452bc4475d946b05eab1a3254")
                .build();
    }

}
