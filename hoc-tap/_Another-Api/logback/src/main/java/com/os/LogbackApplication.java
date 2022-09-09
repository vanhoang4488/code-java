package com.os;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@Slf4j
@SpringBootApplication
public class LogbackApplication {

    public static void main(String[] args){
        SpringApplication.run(LogbackApplication.class, args);
        log.info("what your name?");
    }
}
