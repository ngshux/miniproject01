package com.ssf.miniproject01.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ssf.miniproject01.Model.Data;
import com.ssf.miniproject01.Model.Poem;
import com.ssf.miniproject01.Service.PoemService;
import com.ssf.miniproject01.Service.ScoreRedis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.apache.catalina.connector.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
 
@RestController
@RequestMapping(path = "/poem", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
public class PoemRESTController {
    private static final Logger logger = LoggerFactory.getLogger(PoemRESTController.class);

    @Autowired
    PoemService service;

    @Autowired
    ScoreRedis redisService;

    
    @GetMapping("/generate")
    public ResponseEntity<Poem> generatePoem(@RequestParam (required=true,value ="username") String name){
        Poem generatedPoem = service.generatePoem();        
        return ResponseEntity.ok(generatedPoem);
    }

    @GetMapping(path = "/scoreboard", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Data[]> getAllRecords(){
        Data[] dArr = redisService.getAllScores();
        return ResponseEntity.ok(dArr);
    }
}
