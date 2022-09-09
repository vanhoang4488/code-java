package lab.hoangnv.controller;

import lab.hoangnv.service.impl.BossQuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/bossQuestion")
public class BossQuestionController {

    @Autowired
    private BossQuestionService service;

    @RequestMapping("")
    public ResponseEntity<Object> select(){

        return service.select();
    }
}
