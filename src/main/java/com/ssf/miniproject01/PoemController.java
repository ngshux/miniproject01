package com.ssf.miniproject01;

import java.util.List;

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
        List<String> generatedPoem = service.generatePoem();

        model.addAttribute("username",name);
        model.addAttribute("generatedPoem", generatedPoem);
        
        return "poem";
    }
}
