package main.webapp.java.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

public class WelcomeController {
    @RequestMapping(value = "myAction", method = RequestMethod.GET)
    public String myAction(ModelMap model) {
        model.addAttribute("message", "Welcome to Spring MVC");
        return "MyView";
    }
}
