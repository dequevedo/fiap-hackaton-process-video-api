package com.processvideoapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {"com.processvideoapi"})
public class ProcessVideoAPIApplication {

    public static void main(String[] args) {
        SpringApplication.run(ProcessVideoAPIApplication.class, args);
    }

}
