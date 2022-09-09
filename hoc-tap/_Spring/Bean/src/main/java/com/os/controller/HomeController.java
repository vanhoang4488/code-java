package com.os.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController extends BaseController{

    @RequestMapping("/home")
    public ResponseEntity home(){
        return ResponseEntity.ok("this is home page!!1");
    }
}
