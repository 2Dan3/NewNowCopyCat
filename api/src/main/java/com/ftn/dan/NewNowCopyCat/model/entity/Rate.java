package com.ftn.dan.NewNowCopyCat.model.entity;

import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;

@Entity
@Data
public class Rate {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private Integer performance;

    @Column
    private Integer soundAndLighting;

    @Column
    private Integer venue;

    @Column
    private Integer overallImpression;

    public Rate(Integer performance, Integer soundAndLighting, Integer venue, Integer overallImpression) {
        this.performance = performance;
        this.soundAndLighting = soundAndLighting;
        this.venue = venue;
        this.overallImpression = overallImpression;
    }
}
