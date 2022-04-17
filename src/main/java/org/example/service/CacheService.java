package org.example.service;

import lombok.Data;
import org.example.model.StepSave;
import org.example.event.ParserEventPublisher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
@Data
@Component
public class CacheService {
    Map<String, StepSave> stepSaveMap;

    ParserEventPublisher parserEventPublisher;
//new

    @Autowired
    public CacheService(ParserEventPublisher parserEventPublisher) {
        this.stepSaveMap = new ConcurrentHashMap<>();
        this.parserEventPublisher = parserEventPublisher;

    }

    public String addStepSaveToList(StepSave stepSaveList) {
        String uid = UUID.randomUUID().toString();
        this.stepSaveMap.put(uid, stepSaveList);
        parserEventPublisher.publishCustomEvent(uid);
//new

        return uid;
    }

    public Map<String, StepSave> getCache() {
        return stepSaveMap;
    }
///???
    public StepSave getConfig(String name) {
        return stepSaveMap.get(name);

    }
}
