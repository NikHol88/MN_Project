package org.example.service;

import org.example.Steps;
import org.jsoup.Jsoup;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class JsoupService {
    public String executeRequest(Steps steps) throws IOException {

   return Jsoup.connect(steps.getAction().getValue()).get().toString(); }
}
