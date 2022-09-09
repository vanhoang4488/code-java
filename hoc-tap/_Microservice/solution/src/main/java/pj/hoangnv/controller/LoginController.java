package pj.hoangnv.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/user")
public class LoginController {

    @RequestMapping("/login")
    public ModelAndView login(){
        return new ModelAndView("login");
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(HttpServletRequest request){

        return ResponseEntity.ok("success");
    }

    @RequestMapping("/userdetail")
    public ModelAndView userdetail(){
        return new ModelAndView("userdetail");
    }
}
