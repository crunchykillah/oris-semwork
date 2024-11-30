package ru.itis.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;
@Getter
@Setter
@AllArgsConstructor
public class Exhibition {
    private Long exhibitionId;
    private String name;
    private Date startDate;
    private Date endDate;
    private List<Artwork> artworks;
    private List<Visitor> visitors;
    public Exhibition(Long exhibitionId,String name,Date startDate,Date endDate) {
        this.exhibitionId = exhibitionId;
        this.name = name;
        this.startDate = startDate;
        this.endDate = endDate;
    }
}