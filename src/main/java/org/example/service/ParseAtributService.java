/*
package org.example.service;

import org.example.model.ParserSteps;
import org.example.model.Step;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
//@Service
public class ParseAtributService implements ParserService{
  //???
  //  @Autowired
    CacheService cacheService;
   private Elements parseByAtribut(Step step ){
       Document doc = cacheService.getCache().get();

return doc.select(step.getAction().getValue());
   }


    @Override
    public Object parsStep(Step step) throws IOException {

        return parseByAtribut(step);
    }

*/
