package com.vkhack.proxy.demo;

import jdk.nashorn.internal.objects.annotations.Getter;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class MainController {
    private final RestTemplate restTemplate;

    public MainController(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplate = restTemplateBuilder.build();
    }

    @GetMapping
    public String getIndex() {
        return "index";
    }

    @GetMapping("/proxy")
    @ResponseBody
    public Object sendRequestForGetImage() {
        String url = "https://service.pavel.im/image";
        ResponseEntity<Object> response = this.restTemplate.getForEntity(url, Object.class);
        if (response.getStatusCode() == HttpStatus.OK) {
            return response.getBody();
        } else {
            return null;
        }
    }
}
