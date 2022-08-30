package com.ssf.miniproject01.Model;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ForkJoinPool;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import jakarta.json.Json;
import jakarta.json.JsonArray;
import jakarta.json.JsonObject;
import jakarta.json.JsonReader;

public class Poem {
    private static final Logger logger = LoggerFactory.getLogger(Poem.class);
   
    private String sentence;

    public static Poem getPoemLines(String json) throws IOException{
        Poem p = new Poem();
        try (InputStream is = new ByteArrayInputStream(json.getBytes())){
            JsonReader r = Json.createReader(is);
            JsonArray arr = r.readArray();
            for (int i = 0; i < arr.size(); i++) {
                JsonObject l = arr.getJsonObject(i);
                p.sentence = l.get("q").toString();
            }
        }
        logger.info("Sentence: "+p.sentence);
        return p;
    }

    public String getSentence() {
        return sentence;
    }

    public void setSentence(String sentence) {
        this.sentence = sentence;
    }

    
}
