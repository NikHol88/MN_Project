package org.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ControllerGet {
    @GetMapping("/111")
    public String test11(){
        return "index";
    }

}
