package com.example.superheroes_api;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Random;

@Service
@RequiredArgsConstructor
public class SuperHeroService {

    private static final String API_TOKEN = "c5e195cf74f63f63d68879ff6b6b93f7";
    private static final String API_URL = "https://superheroapi.com/api/" + API_TOKEN + "c5e195cf74f63f63d68879ff6b6b93f7";
    private static final int MAX_HEROES = 731;

    private final RestTemplate restTemplate = new RestTemplate();

    public SuperHeroCard getRandomHeroCard() {
        int randomId = new Random().nextInt(MAX_HEROES) + 1;
        String url = API_URL + randomId;

        SuperHeroResponse response = restTemplate.getForObject(url, SuperHeroResponse.class);
        if (response == null || !"success".equalsIgnoreCase(response.getResponse())) {
            return null;
        }

        SuperHeroCard card = new SuperHeroCard();
        card.setName(response.getName());
        card.setFullName(response.getBiography().getFullName());
        card.setImageUrl(response.getImage().getUrl());
        card.setIntelligence(response.getPowerstats().getIntelligence());
        card.setPower(response.getPowerstats().getPower());
        card.setPublisher(response.getPublisher());

        return card;
    }
}
