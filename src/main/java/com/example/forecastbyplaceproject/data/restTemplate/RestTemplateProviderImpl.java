package com.example.forecastbyplaceproject.data.restTemplate;

import com.example.forecastbyplaceproject.data.restTemplate.interfaces.RestTemplateProvider;
import net.bytebuddy.implementation.bind.annotation.Pipe;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
@Service
@Primary
public class RestTemplateProviderImpl implements RestTemplateProvider{
    @Override
    public RestTemplate getTemplate() {
        return new RestTemplate();
    }
}
