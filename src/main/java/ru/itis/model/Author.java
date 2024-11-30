package ru.itis.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;
@Getter
@Setter
@AllArgsConstructor
public class Author {
    private Long authorId;
    private String name;
    private Date birthDate;
    private Date deathDate;
    private String country;
    private List<Artwork> artworks;

    public Author(Long authorId, String name, Date birthDate,Date deathDate, String country) {
        this.authorId = authorId;
        this.name = name;
        this.birthDate = birthDate;
        this.deathDate = deathDate;
        this.country = country;
    }
}
