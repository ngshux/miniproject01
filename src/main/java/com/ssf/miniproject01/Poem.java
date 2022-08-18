package com.ssf.miniproject01;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import jakarta.json.Json;
import jakarta.json.JsonArray;
import jakarta.json.JsonObject;
import jakarta.json.JsonReader;

public class Poem {
    private static final Logger logger = LoggerFactory.getLogger(Poem.class);
   
    private String author;
    private String title;
    private String lines;
    private String linecount;

    public static List<String> getPoemLines(String json) throws IOException{
        String poemLine;
        List<String> poemPara = new ArrayList<>();
        try (InputStream is = new ByteArrayInputStream(json.getBytes())){
            JsonReader r = Json.createReader(is);
            JsonArray arr = r.readArray();

            for (int i = 0; i < arr.size(); i++) {
                JsonObject p = arr.getJsonObject(i);
                String[] poemLines = p.get("lines").toString().split("\",\"");
                //logger.info("line >> " + poemLine);
                for (int j = 0; j < poemLines.length; j++) {
                    poemPara.add(poemLines[j]);
                }
            }
        }
        return poemPara;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getLines() {
        return lines;
    }

    public void setLines(String lines) {
        this.lines = lines;
    }

    public String getLinecount() {
        return linecount;
    }

    public void setLinecount(String linecount) {
        this.linecount = linecount;
    }
    
}
