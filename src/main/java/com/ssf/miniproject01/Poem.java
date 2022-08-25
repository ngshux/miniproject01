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
   
    private static String author;
    private static String title;
    private static String[] lines;
    private static Integer linecount;

    public static String getPoemLines(String json, Integer lineCount, String lineText) throws IOException{
        StringBuilder poemPara = new StringBuilder();
        linecount = lineCount;

        //Used for /lines.text
        String[] lines = lineText.split("\n");
        for (int i = 1; i < lines.length; i++) {
            poemPara.append(lines[i])
                    .append(System.lineSeparator());
        }
        //logger.info("PARA"+poemPara);

        try (InputStream is = new ByteArrayInputStream(json.getBytes())){
            JsonReader r = Json.createReader(is);
            JsonArray arr = r.readArray();
            for (int i = 0; i < arr.size(); i++) {
                JsonObject p = arr.getJsonObject(i);
                
                author = p.get("author").toString();
                title = p.get("title").toString();

                /*String[] poemLines = p.get("lines").toString().split("\n");
                //logger.info("line >> " + poemLines);
                for (int j = 0; j < poemLines.length; j++) {
                    poemPara.add(poemLines[j]);
                    poemPara.add("\n");
                }*/
            }
        }
        return poemPara.toString();
    }

    public String getAuthor() {
        return author;
    }

    public String getTitle() {
        return title;
    }

    public String[] getLines() {
        return lines;
    }

    public void setLines(String[] lines) {
        this.lines = lines;
    }

    public Integer getLinecount() {
        return linecount;
    }
    
}
