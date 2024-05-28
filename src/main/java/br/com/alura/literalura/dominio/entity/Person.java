package br.com.alura.literalura.dominio.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Data
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Person {
    @Setter
    @Getter
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Setter
    @Getter
    private Integer birthYear;
    @Setter
    @Getter
    private Integer deathYear;
    @Setter
    @Getter
    private String name;

    @Getter
    @ManyToMany(mappedBy = "authors")
    private List<Book> authoredBooks;

    @ManyToMany(mappedBy = "translators")
    private List<Book> translatedBooks;

    // Getters e setters

}

