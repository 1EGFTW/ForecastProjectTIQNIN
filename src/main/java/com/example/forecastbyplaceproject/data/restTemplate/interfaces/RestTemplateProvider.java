package com.example.forecastbyplaceproject.data.restTemplate.interfaces;

import org.springframework.web.client.RestTemplate;

public interface RestTemplateProvider {
    RestTemplate getTemplate();
}
