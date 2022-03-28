package org.example.event;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;

@Component
public class ParserEventPublisher {
    @Autowired
    private ApplicationEventPublisher applicationEventPublisher;

    public void publishCustomEvent(final String uuid) {
        System.out.println("Publishing custom event. ");
        AddConfigEvent customSpringEvent = new AddConfigEvent(this, uuid);//созд соб
        applicationEventPublisher.publishEvent(customSpringEvent);//отправка соб
    }
}
