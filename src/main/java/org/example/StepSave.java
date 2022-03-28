package org.example;

import org.example.service.StepService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class StepSave {
    Map<Step,Object> stepsObjectMap;

    public StepSave(Map<Step,Object> stepsObjectMap) {

        this.stepsObjectMap = stepsObjectMap;
    }

}
