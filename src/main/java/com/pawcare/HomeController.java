package com.pawcare;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.view.freemarker.FreeMarkerConfigurer;

import static freemarker.template.utility.Collections12.singletonList;

@Controller
public class HomeController {

    @GetMapping({"", "/", "/home", "dashboard"})
    public String showDashBoard(){
        return "home";
    }

    @GetMapping("/newUsers")
        public String showSignup(){
        return "user-signup";
    }

    @GetMapping("/403")
    public String _403() {
        return "403";
    }

    @GetMapping("/error")
    public String error() {
        return "error";
    }

}