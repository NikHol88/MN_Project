package org.example.model;

import lombok.Data;

import java.util.Map;

@Data
public class StepSave {
    Map<Step,Result> stepsObjectMap;

    public StepSave(Map<Step,Result> stepsObjectMap) {

        this.stepsObjectMap = stepsObjectMap;
    }

}
