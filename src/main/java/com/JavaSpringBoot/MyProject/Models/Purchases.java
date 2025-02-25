package com.JavaSpringBoot.MyProject.Models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@Entity
@Table(name = "Purchase")
@NoArgsConstructor
public class Purchases {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String full_text;

    public Purchases(String title, String full_text)
    {
        this.title = title;
        this.full_text = full_text;
    }

}
