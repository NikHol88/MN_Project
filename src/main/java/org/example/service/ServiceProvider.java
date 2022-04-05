package org.example.service;

import org.example.ParseWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class ServiceProvider {

    @Autowired
    List<ParserService> parserServiceList;
    Map<ParseWith,ParserService> parseWithParserServiceMap = new HashMap<>();

    @PostConstruct
    public void init(){
        Arrays.stream(ParseWith.values()).forEach(e->{
          ParserService parserService =  parserServiceList
                  .stream()
                  .filter(i-> i.getClass()==e.getObj())
                  .collect(Collectors.toList())
                  .get(0);
          parseWithParserServiceMap.put(e,parserService);
        });
    }
    public ParserService getParserBean(ParseWith parseWith) throws Exception {


        return parseWithParserServiceMap.get(parseWith);  }
}
