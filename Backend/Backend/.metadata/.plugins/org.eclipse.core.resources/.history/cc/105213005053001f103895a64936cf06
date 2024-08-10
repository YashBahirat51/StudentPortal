package com.app.entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Timetable {
    @Id
    private Long id;
    @ManyToOne
    private Faculty faculty;
    private String subject;
    private String day; // or LocalDate
    private String time;

    // Getters and Setters
}
