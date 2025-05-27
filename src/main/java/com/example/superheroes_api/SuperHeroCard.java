package com.example.superheroes_api;

import lombok.Data;

@Data
public class SuperHeroCard {
    private String name;
    private String fullName;
    private String imageUrl;
    private String intelligence;
    private String power;
    private String publisher;
}
