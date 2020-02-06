package org.launchcode.hellospring.controller;


import org.springframework.boot.Banner;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.thymeleaf.model.IModel;

import java.util.ArrayList;
import java.util.List;

@Controller
public class HelloController {
    @RequestMapping(value = "hello", method = {RequestMethod.GET, RequestMethod.POST})
    public static String helloName(@RequestParam String name, Model model) {
        String theGreeting = "Hello, " + name + "!";
        model.addAttribute("greeting", theGreeting);
        return "hello";
    }



    @PostMapping("helloGreeting")
    @ResponseBody
    public static String helloWithParams(@RequestParam String name, @RequestParam String language) {
        String greeting = "Hello ";
        if(language.equals("french")) {
            greeting = "Bonjour ";
        } else if (language.equals("Spanish")) {
            greeting = "Hola";
        } else if (language.equals("thai")) {
            greeting = "Sawadee ";
        } else if (language.equals("italian")) {
            greeting = "Ciao ";
        }
        return "<html>" +
                "<body>" +
                "<h1>" + greeting + name + "!" + "</h1>" +
                "</body>" +
                "</html>";
    }

    @GetMapping("form")
    public String form() {
        return "form";
    }

    @GetMapping("hello/{name}")
    public String helloAgain(@PathVariable String name, Model model){
        String greeting = "Hello, " + name + "!";
        model.addAttribute("greeting", greeting);
        return "hello";
    }

    @GetMapping("hello-names")
    public String helloNames(Model model) {
        List<String> names = new ArrayList<>();
        names.add("LaunchCode");
        names.add("Java");
        names.add("Javascript");
        model.addAttribute("names", names);
        return "hello-list";
    }

}
