package com.JavaSpringBoot.MyProject.Models;

import jakarta.persistence.*;

@Entity
@Table(name = "Purchase")
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String full_text;

    public Post() {
    }

    public Post(String title, String full_text) {
        this.title = title;

        this.full_text = full_text;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getFull_text() {
        return full_text;
    }

    public void setFull_text(String full_text) {
        this.full_text = full_text;
    }
}
