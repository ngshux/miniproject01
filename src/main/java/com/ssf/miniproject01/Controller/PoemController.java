package com.ssf.miniproject01.Controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ssf.miniproject01.Model.Poem;
import com.ssf.miniproject01.Service.PoemService;

@Controller
@RequestMapping("/")
public class PoemController {
    private static final Logger logger = LoggerFactory.getLogger(PoemController.class);

    @Autowired
    PoemService service;

    @GetMapping
    public String getPoems(Model model){
        model.addAttribute("poem", new Poem());
        return "index";
    }

    @RequestMapping("/scoreboard")
    public String getScores(Model model){
        return "scoreboard";
    }

    @PostMapping("/generate")
    public String generatePoem(@RequestParam (required=true,value ="username") String name, Model model){
        Poem generatedPoem = service.generatePoem();  
        model.addAttribute("generatedPoem",generatedPoem);     
        return "typing";
    }

}
