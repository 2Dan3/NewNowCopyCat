package com.ftn.dan.NewNowCopyCat.model.entity;

import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Data
@RequiredArgsConstructor
public class Location {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "location_id")
    private Long id;

    @Column
    private String name;

    @Column
    private String description;

    @Column
    private LocalDate createdAt = LocalDate.now();

    @Column
    private String address;

    @Column
    private Double totalRating;

    @Column
    private String type;



}
