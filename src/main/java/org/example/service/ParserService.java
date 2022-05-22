package org.example.service;

import org.example.model.ParserSteps;
import org.example.model.Result;
import org.example.model.Step;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.IOException;

public abstract class ParserService {

    CacheService cacheService;
@Autowired
    public ParserService(CacheService cacheService) {
        this.cacheService = cacheService;
    }

    abstract public Object parsStep(Step step,String uid) throws IOException;


   // public Object parsStep(Step step, Result result) throws IOException;

}

