package com.example._solution;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class BranchController {

    @Autowired
    private Branch branch;

    @RequestMapping("/a")
    public ResponseEntity a(){
        branch.display();
        return ResponseEntity.ok("success");
    }
}
