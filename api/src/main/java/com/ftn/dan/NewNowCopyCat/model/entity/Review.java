package com.ftn.dan.NewNowCopyCat.model.entity;

import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Data
@RequiredArgsConstructor
public class Review {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private LocalDateTime createdAt = LocalDateTime.now();

    @Column
    private Boolean hidden = false;

    @ManyToOne(optional = false, fetch = FetchType.EAGER, cascade = {CascadeType.PERSIST, CascadeType.REMOVE})
    private Rate rate;

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Location location;

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Event event;

    @ManyToOne(optional = true, fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.REMOVE})
    private Comment comment;

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private User user;

    @Column
    private Integer occurrencesHappened;
}
