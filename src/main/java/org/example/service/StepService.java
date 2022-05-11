package org.example.service;

import org.example.model.Result;
import org.example.model.Step;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class StepService {

    public Map<Step,Result> stepListToMap( List<Step> steps){
        Map<Step,Result> stepObjectMap =new HashMap<>();
        steps.forEach(step ->stepObjectMap.put(step,new Result()) );
           return stepObjectMap; }

}
