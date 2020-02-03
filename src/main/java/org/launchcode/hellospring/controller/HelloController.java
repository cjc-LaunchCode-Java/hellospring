package org.launchcode.hellospring.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("hello")
@ResponseBody
public class HelloController {
    @PostMapping("hello")
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
        return "<html>" +
                "<body>" +
                "<form method = 'post' action='hello'>" +
                "  <label for='name'>Name: <input type='text' name = 'name'></label>" +
                "  <label for='language'>Language: </label>" +
                "  <select type='text' name = 'language'>" +
                "    <option value='english'>English</option>" +
                "    <option value='french'>French</option>" +
                "    <option value='spanish'>Spanish</option>" +
                "    <option value='thai'>Thai</option>" +
                "    <option value='italian'>Italian</option>" +
                "  </select>" +
                "  <input type='submit'>" +
                "</form>" +
                "</body>" +
                "</html>";
    }



}
