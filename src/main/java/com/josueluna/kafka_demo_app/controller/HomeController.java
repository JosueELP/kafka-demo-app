package com.josueluna.kafka_demo_app.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

    private static final Logger log = LoggerFactory.getLogger(HomeController.class);

    @GetMapping(value = "/home", produces = "application/json")
    public String getHomeMessage() {
        log.info("Entering /home endpoint");

        return "Hello World!";
    }

}
