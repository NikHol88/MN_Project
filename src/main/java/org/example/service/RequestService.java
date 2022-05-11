package org.example.service;

import org.example.model.ParserSteps;
import org.example.model.Step;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
@Qualifier(value = "jsoup")
//rename RequestService
public class RequestService implements ParserService {
 /*   public String executeRequest(List<Step> steps) throws IOException {

        return Jsoup.connect(steps.get(0).getAction().getValue()).get().toString();
    }*/

    public Document executeElement(Step steps) throws IOException {


        return Jsoup.connect(steps.getAction().getValue()).get();


    }




    @Override
    public Object parsStep(Step step) throws IOException {
return
        executeElement(step);

    }

  /*  @Override
    public Object parsStep(Step step, Result result) throws IOException {

        return executeElement(step);
   }*/
}
