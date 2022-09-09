package com.os;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/manage")
public class ManageController {

    @Value("${server.port}")
    private String port;

    private static final String MSG = "manage";

    @RequestMapping("/service")
    public String getService(){
      log.info("========>{}<=========", MSG);
      return MSG + ": " + port;
    }
}
