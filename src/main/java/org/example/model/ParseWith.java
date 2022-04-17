package org.example.model;
import org.example.service.JsoupService;
import org.example.service.ParserService;

public enum ParseWith {
    JSOUP(JsoupService.class),
    PHANTOMJS(JsoupService.class);
    Class<ParserService> obj;

    ParseWith(Class obj) {
        this.obj = obj;
    }

    public Class<ParserService> getObj() {
        return obj;
    }
}
