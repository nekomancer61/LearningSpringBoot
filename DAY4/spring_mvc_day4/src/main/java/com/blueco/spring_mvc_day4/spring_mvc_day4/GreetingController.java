package com.blueco.spring_mvc_day4.spring_mvc_day4;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class GreetingController {
    
    @GetMapping("/greeting")
    public String gretting(@RequestParam(name="name", required = false, defaultValue = "nekomancer") String name, Model model){
        model.addAttribute("name",name);
        return "greeting";

    }
}
