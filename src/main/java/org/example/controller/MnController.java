package org.example.controller;

import org.example.Steps;
import org.example.service.JsoupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController

public class MnController {

    JsoupService jsoupService;
    @Autowired
    public MnController(JsoupService jsoupService) {
        this.jsoupService = jsoupService;
    }

    @RequestMapping(value="/test",method = RequestMethod.POST)
    public String save(@RequestBody Steps steps) throws IOException {


        return jsoupService.executeRequest(steps);
    }
    @GetMapping("/222")
        public String test(String str){
        System.out.println(str);
        return  "index";
    }

}
