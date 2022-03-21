package org.example.service;

import org.example.Step;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class JsoupService {
    public String executeRequest(Step steps) throws IOException {

   return Jsoup.connect(steps.getAction().getValue()).get().toString(); }

    public String executeElement(Step steps) throws IOException {
        String set = steps.getAction().getSet();
        Elements newsHeadlines=null;
        String set1="atribute";
        System.out.println(set+set1);

        if (set.equalsIgnoreCase("atribute")){
    String value = steps.getAction().getValue();
        Document doc = Jsoup.connect("https://ria.ru/lenta").get();

         newsHeadlines = doc.select(value);
        for (Element headline : newsHeadlines) {
            System.out.println(headline);
        }}
        else if (set.equalsIgnoreCase("Class")){
            String value = steps.getAction().getValue();
            Document doc = Jsoup.connect("https://ria.ru/lenta").get();

            newsHeadlines = doc.getElementsByClass(value);
            for (Element headline : newsHeadlines) {
                System.out.println(headline);
            }}
        else {
            return "error";
        }


    return String.valueOf(newsHeadlines);}

}
