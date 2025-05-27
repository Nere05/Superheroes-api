package com.example.superheroes_api;

import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/api/superhero")
@RequiredArgsConstructor
public class SuperHeroController {

    private final SuperHeroService superHeroService;

    @GetMapping("/random")
    public SuperHeroCard getRandomHero() {
        return superHeroService.getRandomHeroCard();
    }
}
