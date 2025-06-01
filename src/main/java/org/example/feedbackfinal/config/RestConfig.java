package org.example.FeedBackFinalApplication.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class RestConfig {

    /** Cliente HTTP para llamar al API externo */
    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
