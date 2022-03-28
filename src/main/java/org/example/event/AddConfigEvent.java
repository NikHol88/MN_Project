package org.example.event;

import org.springframework.context.ApplicationEvent;

public class AddConfigEvent extends ApplicationEvent {
   private String uuid;

    public AddConfigEvent(Object source, String uuid) {
        super(source);
        this.uuid = uuid;
    }

    public String getUuid() {
        return uuid;
    }
}
