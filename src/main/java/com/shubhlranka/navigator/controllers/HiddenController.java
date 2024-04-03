package com.shubhlranka.navigator.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class HiddenController {

    @GetMapping("/hidden-feature/{number}")
    public String hiddenFeature(@PathVariable("number") int number) {
        String uri = "http://numbersapi.com/" + number;
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.getForObject(uri, String.class);
    }
}
