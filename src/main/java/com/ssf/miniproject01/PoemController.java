package com.ssf.miniproject01;

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

    @PostMapping("/generate")
    public String generatePoem(@RequestBody String form, Model model){
        String name = form;
        String generatedPoem = service.generatePoem();
        Poem p = new Poem();

        model.addAttribute("username",name);
        model.addAttribute("title",p.getTitle());
        model.addAttribute("author",p.getAuthor());
        model.addAttribute("linecount",p.getLinecount());
        model.addAttribute("generatedPoem", generatedPoem);
        
        return "poem";
    }
}
