package br.com.alura.literalura.dominio.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Data
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Setter
    @Getter
    private String title;

    @Getter
    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Person> authors = new ArrayList<>();

    @ManyToMany
    private List<Person> translators;

    @ElementCollection
    private List<String> subjects;

    @ElementCollection
    private List<String> bookshelves;

    @Getter
    @Setter
    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(name = "book_languages", joinColumns = @JoinColumn(name = "book_id"))
    @Column(name = "languages")
    private List<String> languages;

    private Boolean copyright;
    private String mediaType;

    @OneToMany(mappedBy = "book", cascade = CascadeType.ALL)
    private List<Format> formats;

    @Getter
    @Setter
    private Double downloadCount;

}
