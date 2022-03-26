package org.example;

import org.example.service.StepService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StepSave {
    Map<Step,Object> stepsObjectMap;
    @Autowired
StepService stepService;

    public StepSave(List<Step> steps) {

        this.stepsObjectMap = stepService.stepListToMap(steps);
    }

}
