package org.example.ryan.tianapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties
public class TianApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(TianApiApplication.class, args);
    }

}