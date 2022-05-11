package org.example.model;
import org.example.service.RequestService;
import org.example.service.ParserService;

public enum ParseWith {
    JSOUP(RequestService.class),
    PHANTOMJS(RequestService.class);
    Class<ParserService> obj;

    ParseWith(Class obj) {
        this.obj = obj;
    }

    public Class<ParserService> getObj() {
        return obj;
    }
}
