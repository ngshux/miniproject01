package com.ssf.miniproject01;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class PoemService {
    private static final Logger logger = LoggerFactory.getLogger(PoemService.class);
    private static final String apiURL = "https://zenquotes.io/api/random/";

    @Autowired
    RestTemplate template = new RestTemplate();

    public Poem generatePoem() {
        ResponseEntity<String> resp = null;
        Poem generatedPoem = null;
        try {
            resp = template.getForEntity(apiURL, String.class);
            generatedPoem = Poem.getPoemLines(resp.getBody());
            
        } catch (Exception e) {
            e.printStackTrace();
        }

        return generatedPoem;
    }
}
