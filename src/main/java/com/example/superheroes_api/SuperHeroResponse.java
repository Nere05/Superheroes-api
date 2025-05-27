package com.example.superheroes_api;

import lombok.Data;

@Data
public class SuperHeroResponse {
    private String response;
    private String id;
    private String name;
    private Biography biography;
    private Powerstats powerstats;
    private Image image;
    private String publisher;

    @Data
    public static class Biography {
        private String fullName;
    }

    @Data
    public static class Powerstats {
        private String intelligence;
        private String power;
    }

    @Data
    public static class Image {
        private String url;
    }
}
