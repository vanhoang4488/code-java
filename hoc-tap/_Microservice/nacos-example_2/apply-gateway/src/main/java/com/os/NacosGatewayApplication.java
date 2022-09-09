package com.os;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
public class NacosGatewayApplication {

    public static void main(String[] args){
        SpringApplication.run(NacosGatewayApplication.class, args);
    }
}
