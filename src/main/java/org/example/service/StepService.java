package org.example.service;

import org.example.ParseWith;
import org.example.Result;
import org.example.Step;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class StepService {
    @Autowired
    ApplicationContext applicationContext;
    public Map<Step,Object> stepListToMap( List<Step> steps){
        Map<Step,Object> stepObjectMap =new HashMap<>();
        steps.forEach(step ->stepObjectMap.put(step,new Result()) );
   return stepObjectMap; }
    public ParserService getParserBean(ParseWith parseWith) throws Exception {
        switch (parseWith){
            case JSOUP -> {
                return applicationContext.getBean(JsoupService.class);
            }

            case PHANTOMJS -> {
                return applicationContext.getBean(JsoupService.class);
            }
            default -> {
                throw new Exception();
            }  }

    }
}
