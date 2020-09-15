package com.vkhack.proxy.demo;

import org.springframework.http.HttpMethod;
import org.springframework.http.HttpRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

import java.awt.image.BufferedImage;

@Controller
public class MainController {
    @GetMapping
    public String getIndex() {
        return "index";
    }

    @GetMapping("/proxy")
    @ResponseBody
    public Object sendRequestForGetImage() {
        RestTemplate restTemplate = new RestTemplate();
        String url = "https://service.pavel.im/image";
        ResponseEntity<byte[]> response = restTemplate.exchange(url, HttpMethod.GET, null, byte[].class);
        System.out.println(response.getBody());
        System.out.println(response.getStatusCode());
        System.out.println(response.getHeaders());
        return response.getBody();
    }
}
