package com.vkhack.proxy.demo;

import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

@Controller
@CrossOrigin
public class MainController {
    @GetMapping
    public String getIndex() {
        return "index";
    }

    @GetMapping(value = "/proxy", produces = MediaType.IMAGE_JPEG_VALUE)
    @ResponseBody
    public Object sendRequestForGetImage() {
        RestTemplate restTemplate = new RestTemplate();
        String url = "https://service.pavel.im/image";
        ResponseEntity<byte[]> response = restTemplate.exchange(url, HttpMethod.GET, null, byte[].class);
        return response.getBody();
    }
}
