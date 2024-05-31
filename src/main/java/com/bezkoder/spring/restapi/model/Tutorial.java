package com.bezkoder.spring.restapi.model;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import org.springframework.boot.autoconfigure.gson.GsonAutoConfiguration;
import org.springframework.boot.json.GsonJsonParser;

import java.util.ArrayList;
import java.util.List;

public class Tutorial {
    @JsonSerialize
    private long id = 0;
    @JsonSerialize
    private String title;
    @JsonSerialize
    private String description;
    @JsonSerialize
    private boolean published;


    public Tutorial() {

    }

    public Tutorial(int id, String title, String description, boolean published) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.published = published;
    }

    public List<Tutorial> listOfTutorials() {
        List<Tutorial> tutorials = new ArrayList<Tutorial>();
        tutorials.add(new Tutorial(1, "hello", "world1", true));
        tutorials.add(new Tutorial(2, "hello1", "world2", true));
        tutorials.add(new Tutorial(3, "hello2", "world3", true));
        tutorials.add(new Tutorial(4, "hello4", "world4", true));
        tutorials.add(new Tutorial(5, "hello5", "world5", true));
        tutorials.add(new Tutorial(6, "hello6", "world6", true));
        tutorials.add(new Tutorial(7, "duart", "mustafi", false));
        return tutorials;
    }


    public void setId(long id) {
        this.id = id;
    }

    public long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isPublished() {
        return published;
    }

    public void setPublished(boolean isPublished) {
        this.published = isPublished;
    }

    @Override
    public String toString() {
        return "Tutorial [id=" + id + ", title=" + title + ", desc=" + description + ", published=" + published + "]";
    }
}
