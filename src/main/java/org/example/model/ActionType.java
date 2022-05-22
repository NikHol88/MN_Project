package org.example.model;

import org.example.service.ParseAtributService;
import org.example.service.ParseClassService;
import org.example.service.ParserService;
import org.example.service.RequestService;

import java.lang.reflect.Method;

public enum ActionType {
    REQUEST(RequestService.class),
    PARSE_ATRIBUT(ParseAtributService.class),
    PARSE_CLASS(ParseClassService.class);
    Class<ParserService> obj;
    ActionType(Class obj) {
        this.obj = obj;
    }

    public Class<ParserService> getObj() {
        return obj;
    }
}
