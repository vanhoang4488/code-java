package com.os.controller;


import org.aspectj.lang.annotation.Pointcut;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/oplog")
public class AspectController {



    @RequestMapping("/1")
    public ResponseEntity oplog(@RequestParam String arg){
        return ResponseEntity.ok("ok");
    }
}
