package com.example.superheroes_api;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequiredArgsConstructor
public class WebController {

    private final SuperHeroService superHeroService;

    @GetMapping("/")
    public String showRandomHero(Model model) {
        SuperHeroCard heroCard = superHeroService.getRandomHeroCard();
        model.addAttribute("hero", heroCard);
        return "heroCard"; // nombre del archivo HTML (sin extensión)
    }
}
