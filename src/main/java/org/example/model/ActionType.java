package org.example.model;

import org.example.service.ParserService;
import org.example.service.RequestService;

import java.lang.reflect.Method;

public enum ActionType {
    REQUEST(RequestService.class),
    PARSE_ATRIBUT(RequestService.class),
    PARSE_CLASS(RequestService.class);
    Class<ParserService> obj;
    ActionType(Class obj) {
        this.obj = obj;
    }

    public Class<ParserService> getObj() {
        return obj;
    }
}
