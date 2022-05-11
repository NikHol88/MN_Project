package org.example.service;

import org.example.model.ParserSteps;
import org.example.model.Result;
import org.example.model.Step;

import java.io.IOException;

public interface ParserService {
    public Object parsStep(Step step) throws IOException;

   // public Object parsStep(Step step, Result result) throws IOException;

}

