package org.example;

import org.example.service.StepService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class StepSave {
    Map<Step,Result> stepsObjectMap;

    public StepSave(Map<Step,Result> stepsObjectMap) {

        this.stepsObjectMap = stepsObjectMap;
    }

}
