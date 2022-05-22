
package org.example.service;

import org.example.model.ParserSteps;
import org.example.model.Step;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.stream.Collectors;

@Service
public class ParseAtributService extends ParserService {


    public ParseAtributService(CacheService cacheService) {
        super(cacheService);
    }

    private Object parseByAtribut(Step step, String uid) {
        Elements elements = null;
        Step step1 = cacheService
                .getCache()
                .get(uid)
                .getStepsObjectMap()
                .keySet()
                .stream()
                .filter(e -> e.getStepId() == step.getStepId() - 1)
                .collect(Collectors.toList())
                .get(0);
        Object obj = cacheService.getCache().get(uid).getStepsObjectMap().get(step1).getResult();
        if (Document.class.isInstance(obj)){
            Document doc = (Document)obj;
            elements = doc.select(step.getAction().getValue());
        }

        return elements;
    }


    @Override
    public Object parsStep(Step step, String uid) throws IOException {

        return parseByAtribut(step, uid);
    }
}

