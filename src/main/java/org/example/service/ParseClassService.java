package org.example.service;

import org.example.model.ParserSteps;
import org.example.model.Step;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.stream.Collectors;

@Service
public class ParseClassService extends ParserService {


    public ParseClassService(CacheService cacheService) {
        super(cacheService);
    }

    @Override
    public Object parsStep(Step step,String uid) throws IOException {
        Elements newsHeadlines=null;
        Step step1 = cacheService.getCache().get(uid).getStepsObjectMap()
                .keySet()
                .stream()
                .filter(e->e.getStepId()==step.getStepId()-1)
                .collect(Collectors.toList())
                .get(0);
        Object obj = cacheService.getCache().get(uid).getStepsObjectMap().get(step1).getResult();
        if (Document.class.isInstance(obj)) {  //проверка на Document
            Document doc = (Document)obj;
            newsHeadlines = doc.getElementsByClass(step.getAction().getValue());
        }
        return newsHeadlines;
    }
}
