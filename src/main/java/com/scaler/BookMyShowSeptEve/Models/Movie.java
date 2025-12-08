package com.scaler.BookMyShowSeptEve.Models;

import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
public class Movie extends  BaseModel {
    private String name;
    private String genre;
    private int run_time_mins;

    @ElementCollection
    private List<String> actors;

    @Enumerated(EnumType.ORDINAL)
    @ElementCollection
    private List<Language> languages;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public int getRun_time_mins() {
        return run_time_mins;
    }

    public void setRun_time_mins(int run_time_mins) {
        this.run_time_mins = run_time_mins;
    }

    public List<String> getActors() {
        return actors;
    }

    public void setActors(List<String> actors) {
        this.actors = actors;
    }

    public List<Language> getLanguages() {
        return languages;
    }

    public void setLanguages(List<Language> languages) {
        this.languages = languages;
    }
}

    // movie_actor : id | movie_id | actor