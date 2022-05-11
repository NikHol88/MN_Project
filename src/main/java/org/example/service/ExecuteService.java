package org.example.service;

import org.example.model.Result;
import org.example.model.Step;
import org.example.model.StepSave;
import org.example.event.AddConfigEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ExecuteService {
    @Autowired
    CacheService cacheService;
    @Autowired
    ServiceProvider serviceProvider;
    @EventListener(classes = AddConfigEvent.class)
public void executeConfig(AddConfigEvent event){
    System.out.println("Execute"+event.getUuid());
StepSave stepSave = cacheService.getConfig(event.getUuid());

List<Step> stepList = stepSave
        .getStepsObjectMap()
        .keySet()
        .stream().sorted(Comparator.comparing(Step::getStepId))
        .collect(Collectors.toList());
        stepList.forEach(e->{
           ParserService parserService = serviceProvider.getParserBean(e.getParseWith());
            Object obj = null ;
           try {

               obj =   parserService.parsStep(e);
            } catch (IOException ex) {
                ex.printStackTrace();
            }
            stepSave.getStepsObjectMap().get(e).setResult(obj);
        });

}
}
