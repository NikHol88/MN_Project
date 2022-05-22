package org.example.controller;

import org.example.model.*;
import org.example.service.CacheService;
import org.example.service.ConfigSaveService;
import org.example.service.ServiceProvider;
import org.example.service.StepService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000/")
public class MnController {
    StepService stepService;
    CacheService cacheService;
    ServiceProvider serviceProvider;
    ConfigSaveService configSaveService;

    @Autowired
    public MnController(StepService stepService, CacheService cacheService, ServiceProvider serviceProvider,
                        ConfigSaveService configSaveService) {
        this.stepService = stepService;
        this.cacheService = cacheService;
        this.serviceProvider = serviceProvider;
        this.configSaveService = configSaveService;

    }


    @RequestMapping(value = "/elem", method = RequestMethod.GET)
    public String saveElement() throws Exception {


        return "model";//???
    }

    @RequestMapping(value = "/elem1", method = RequestMethod.POST)
    public void eventCache(@RequestBody ParserSteps parserSteps) throws Exception {

        String uid = cacheService
                .addStepSaveToList(new StepSave(stepService
                        .stepListToMap(parserSteps.getSteps())));
        Result result = cacheService.getCache().get(uid).getStepsObjectMap().get(parserSteps.getSteps().get(1));
        System.out.println(result.toString());
    }

    @RequestMapping(value = "/saveconfig", method = RequestMethod.POST)
    public void saveConfig(@RequestBody ParserSteps parserSteps) throws Exception {
        configSaveService.saveConfig(parserSteps);

    }

    @RequestMapping(value = "/readconfig", method = RequestMethod.GET)
    public ParserSteps readConfig(@RequestParam(value = "name", required = false) String name) throws Exception {

        ParserSteps parserSteps = configSaveService.readForNameConfig(name);
        System.out.println(parserSteps.toString());
        return parserSteps;
    }
  /*  @RequestMapping(value = "/parseconfig", method = RequestMethod.GET)
    public ParserSteps parseConfig() throws Exception {

        ParserSteps parserSteps = configSaveService.readForNameConfig("Nik");

        cacheService.addStepSaveToList(parserSteps.getSteps())
        return parserSteps ;
    }*/

    @RequestMapping(value = "/fromDBinCache", method = RequestMethod.GET)
    public String readStepConfig() throws Exception {


        return "ok";
    }
}



