package org.example.event;

import org.example.service.CacheService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Component
public class ParserEventListener implements ApplicationListener<AddConfigEvent> {
    @Autowired
    CacheService cacheService;
    @Override//принимает событие ParserEventPublisher
    public void onApplicationEvent(AddConfigEvent event) {
        System.out.println("event ok"+cacheService.getCache());
    }
}
