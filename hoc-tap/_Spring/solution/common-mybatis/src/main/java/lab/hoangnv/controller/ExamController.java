package lab.hoangnv.controller;

import lab.hoangnv.service.impl.ExamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/exam")
public class ExamController {

    @Autowired
    private ExamService service;

    @RequestMapping("")
    public ResponseEntity<Object> select(){

        return service.select();
    }
}
