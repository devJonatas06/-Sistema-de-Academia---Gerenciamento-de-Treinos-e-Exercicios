package com.Treinos.api.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/")
    public String redirectToTrainerForm() {
        return "redirect:/treinos/list";
    }
}
