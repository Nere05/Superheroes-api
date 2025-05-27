package com.example.superheroes_api;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

// import ch.qos.logback.core.model.Model;
import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping("/api/superhero")
@RequiredArgsConstructor
public class SuperHeroController {

    private final SuperHeroService superHeroService;

    @GetMapping("/random")
    public SuperHeroCard getRandomHero() {
        return superHeroService.getRandomHeroCard();
    }
@GetMapping("/")
public String showRandomHero(Model model) {
    SuperHeroCard heroCard = superHeroService.getRandomHeroCard();
    if (heroCard == null) {
        // En caso de que no se obtenga ningún héroe, pasar un objeto vacío o con valores por defecto
        heroCard = new SuperHeroCard();
        heroCard.setName("No encontrado");
        heroCard.setImageUrl("/images/default.png"); // Pon una imagen local por si acaso
        heroCard.setFullName("Desconocido");
        heroCard.setIntelligence("0");
        heroCard.setPower("0");
        heroCard.setPublisher("Desconocido");
    }
    model.addAttribute("hero", heroCard);
    return "heroCard";
}

}
