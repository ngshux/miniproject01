package com.ssf.miniproject01;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

@Service
public class PoemService {
    private static final Logger logger = LoggerFactory.getLogger(PoemService.class);
    private static final String apiURL = "https://poetrydb.org";

    @Autowired
    RestTemplate template = new RestTemplate();

    public List<String> generatePoem() {
        Random rand = new Random();
        Integer lineCount;

        lineCount = (rand.nextInt(100)+50); 

        String poemURL = UriComponentsBuilder.fromUriString(apiURL)
                            .path("/linecount,random/" + lineCount+ ";1")
                            .toUriString();
        logger.info("url >> " + poemURL);

        ResponseEntity<String> resp = null;
        List<String> generatedPoem = new ArrayList<>();
        try {
            resp = template.getForEntity(poemURL, String.class);
            generatedPoem = Poem.getPoemLines(resp.getBody());
            
        } catch (Exception e) {
            e.printStackTrace();
        }

        return generatedPoem;
    }
}
