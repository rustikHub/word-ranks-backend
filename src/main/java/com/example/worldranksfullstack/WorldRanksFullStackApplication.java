package com.example.worldranksfullstack;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class WorldRanksFullStackApplication {

    public static void main(String[] args) {
        SpringApplication.run(WorldRanksFullStackApplication.class, args);
    }

}
