package com.JavaSpringBoot.MyProject.Models;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;

@Data
@Entity
@Table(name = "Purchase")
@NoArgsConstructor
public class Purchases implements Serializable {
    @Getter
    @Setter
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Setter
    @Getter
    private String title;
    @Setter
    private String full_text;
    private Long userId;

    public Purchases(String title, String full_text, Long userId)
    {
        this.title = title;
        this.full_text = full_text;
        this.userId = userId;
    }
}
