package com.hackathon.equipo2.CineHackacthon.models;

public class MovieModel {
    private Long id;
    private String name;
    private String synopsis;

    public MovieModel() {
    }

    public MovieModel(Long id, String name, String synopsis) {
        this.id = id;
        this.name = name;
        this.synopsis = synopsis;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSynopsis() {
        return synopsis;
    }

    public void setSynopsis(String synopsis) {
        this.synopsis = synopsis;
    }
}
