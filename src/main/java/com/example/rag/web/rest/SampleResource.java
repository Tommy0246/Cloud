package com.example.rag.web.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SampleResource {

    @GetMapping("/samples/{value}")
    public String hello(@PathVariable(value = "value", required = false) final String value) {
        return "Hello " + value + "!";
    }

    /*@GetMapping("/samples/dto/{value}")
    public Sample helloJson(@PathVariable(value = "value", required = false) final String value) {
        return new Sample(value: "Hello " + value + "!");
    }*/

}
