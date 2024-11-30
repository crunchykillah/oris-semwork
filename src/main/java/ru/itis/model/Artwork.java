package ru.itis.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter@Setter@AllArgsConstructor
public class Artwork {
    private Long artworkId;
    private String title;
    private Integer creationYear;
    private Author author;
}