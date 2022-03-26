package org.example.service;

import org.example.Step;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
public class JsoupService implements ParserService{
    public String executeRequest(List<Step> steps) throws IOException {

   return Jsoup.connect(steps.get(0).getAction().getValue()).get().toString(); }

    public String executeElement(List<Step> steps) throws IOException {
        String set = steps.get(1).getAction().getSet();
        Elements newsHeadlines=null;
        String set1="atribute";
        System.out.println(set+set1);

        if (set.equalsIgnoreCase("atribute")){
    String value = steps.get(1).getAction().getValue();
        Document doc = Jsoup.connect("https://ria.ru/lenta").get();

         newsHeadlines = doc.select(value);
        for (Element headline : newsHeadlines) {
            System.out.println(headline);
        }}
        else if (set.equalsIgnoreCase("Class")){
            String value = steps.get(1).getAction().getValue();
            Document doc = Jsoup.connect("https://ria.ru/lenta").get();

            newsHeadlines = doc.getElementsByClass(value);
            for (Element headline : newsHeadlines) {
                System.out.println(headline);
            }}
        else {
            return "error";
        }


    return String.valueOf(newsHeadlines);}

    @Override
    public void parsStep(Step step) {

    }
}
