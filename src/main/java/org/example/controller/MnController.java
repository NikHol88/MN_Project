package org.example.controller;

import org.example.Step;
import org.example.service.JsoupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController

public class MnController {

    JsoupService jsoupService;
    @Autowired
    public MnController(JsoupService jsoupService) {
        this.jsoupService = jsoupService;
    }

    @RequestMapping(value="/test",method = RequestMethod.POST)
    public String save(@RequestBody List<Step> steps) throws IOException {


        return jsoupService.executeRequest(steps);
    }
    @RequestMapping(value="/elem",method = RequestMethod.POST)
    public String saveElement(@RequestBody List<Step> steps) throws IOException {


        return jsoupService.executeElement(steps);
    }

    @GetMapping("/222")
        public String test(String str){
        System.out.println(str);
        return  "index";
    }

}
