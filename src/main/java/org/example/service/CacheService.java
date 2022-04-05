package org.example.service;

import org.example.StepSave;
import org.example.event.ParserEventPublisher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

@Component
public class CacheService {
    Map<String, StepSave> stepSaveList;

    ParserEventPublisher parserEventPublisher;

    @Autowired
    public CacheService(ParserEventPublisher parserEventPublisher) {
        this.stepSaveList = new ConcurrentHashMap<>();
        this.parserEventPublisher = parserEventPublisher;
    }

    public String addStepSaveToList(StepSave stepSaveList) {
        String uid = UUID.randomUUID().toString();
        this.stepSaveList.put(uid, stepSaveList);
        parserEventPublisher.publishCustomEvent(uid);
        return uid;
    }

    public Map<String, StepSave> getCache() {
        return stepSaveList;
    }

    public StepSave getConfig(String name) {
        return stepSaveList.get(name);

    }
}
