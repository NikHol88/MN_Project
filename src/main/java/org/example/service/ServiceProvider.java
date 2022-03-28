package org.example.service;

import org.example.ParseWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

@Service
public class ServiceProvider {
    @Autowired
    ApplicationContext applicationContext;
    public ParserService getParserBean(ParseWith parseWith) throws Exception {


        return applicationContext.getBean(parseWith.getObj());  }
}
