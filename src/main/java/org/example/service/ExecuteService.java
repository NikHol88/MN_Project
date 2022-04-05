package org.example.service;

import org.example.StepSave;
import org.example.event.AddConfigEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

@Service
public class ExecuteService {
    @Autowired
    CacheService cacheService;
    @EventListener(classes = AddConfigEvent.class)
public void executeConfig(AddConfigEvent event){
    System.out.println("Execute"+event.getUuid());
StepSave stepSave = cacheService.getConfig(event.getUuid());
}
}
