package com.ftn.dan.NewNowCopyCat.model.entity;

import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Data
@RequiredArgsConstructor
public class Event {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String name;

    @Column
    private String address;

    @Column
    private String type;

    @Column
    private LocalDate date;

    @Column
    private Double price;

    @Column(nullable = false)
    private Boolean recurrent;

    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Location location;
}
