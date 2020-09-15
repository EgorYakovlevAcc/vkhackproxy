package com.vkhack.proxy.demo;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

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
        String url = "http://service.pavel.im/image";
        ResponseEntity<Object> response = restTemplate.getForEntity(url, Object.class);
        if (response.getStatusCode() == HttpStatus.OK) {
            return response.getBody();
        } else {
            return null;
        }
    }
}
