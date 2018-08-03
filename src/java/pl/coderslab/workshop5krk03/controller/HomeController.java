package pl.coderslab.workshop5krk03.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping ("")
    public String home() {
        return "Server is waitng";
    }
}
