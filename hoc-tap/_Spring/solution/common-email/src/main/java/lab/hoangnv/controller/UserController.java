package lab.hoangnv.controller;

import lab.hoangnv.service.MailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private MailService mailService;

    @RequestMapping("/mail")
    public ResponseEntity<Object> mail(){
        String message = mailService.sendMail("vanhoang48.nguyen@gmail.com");
        return ResponseEntity.ok("success");
    }
}
