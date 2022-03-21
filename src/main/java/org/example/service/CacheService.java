package org.example.service;

import org.example.StepSave;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class CacheService {
    Map<String,StepSave> stepSaveList;

    public CacheService( ){
        this.stepSaveList = new HashMap<>();
    }

    public String addStepSaveToList(StepSave stepSaveList) {
        String uid = UUID.randomUUID().toString();
        this.stepSaveList.put(uid, stepSaveList);
    return uid;}
}
