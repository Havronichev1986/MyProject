package com.JavaSpringBoot.MyProject.Models;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import java.io.Serializable;

@Data
@Entity
@Table(name = "Purchase")
@NoArgsConstructor
public class Purchases implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String full_text;
    private Long userId;

    public Long getId() {return id;}
    public void setId(Long id) {this.id = id;}

    public Purchases(String title, String full_text, Long userId)
    {
        this.title = title;
        this.full_text = full_text;
        this.userId = userId;
    }

    public String getFull_text() {
        return full_text;
    }

    public void setFull_text(String full_text) {
        this.full_text = full_text;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
