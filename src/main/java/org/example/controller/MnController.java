package org.example.controller;

import org.example.ParseWith;
import org.example.Step;
import org.example.StepSave;
import org.example.service.CacheService;
import org.example.service.JsoupService;
import org.example.service.ServiceProvider;
import org.example.service.StepService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000/")
public class MnController {
    StepService stepService;
    CacheService cacheService;
ServiceProvider serviceProvider;
    @Autowired
    public MnController(StepService stepService, CacheService cacheService,ServiceProvider serviceProvider) {
        this.stepService = stepService;
        this.cacheService = cacheService;
        this.serviceProvider = serviceProvider;
    }


    @RequestMapping(value = "/elem", method = RequestMethod.POST)
    public String saveElement(@RequestBody List<Step> steps) throws Exception {
        ParseWith parseWith = steps.get(1).getParseWith();

        return (serviceProvider.getParserBean(parseWith)).parsStep(steps.get(1));
    }

    @RequestMapping(value = "/elem1", method = RequestMethod.POST)
    public void eventCache(@RequestBody List<Step> steps) throws Exception {
cacheService.addStepSaveToList(new StepSave(stepService.stepListToMap(steps)));

    }

    @GetMapping("/222")
    public String test(String str) {
        System.out.println(str);
        return "index";
    }

}
