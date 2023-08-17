package com.example.observation.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Observation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private LocalDate date;
    private String description;
    private String picture;
    private boolean display;
    private int objetId;
    private int userId;

    public Observation(LocalDate date, String description, String picture, boolean display, int objetId, int userId) {
        this.date = date;
        this.description = description;
        this.picture = picture;
        this.display = display;
        this.objetId = objetId;
        this.userId = userId;
    }
}
