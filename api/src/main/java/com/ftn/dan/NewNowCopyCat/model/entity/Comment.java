package com.ftn.dan.NewNowCopyCat.model.entity;

import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Data
@RequiredArgsConstructor
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String text;

    @Column
    private LocalDateTime createdAt = LocalDateTime.now();

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private User user;

    @ManyToOne(optional = true, fetch = FetchType.LAZY)
    private Comment parentComment;

    @Column(nullable = false)
    private Boolean deleted = false;

    public Comment(String text, User author, Comment parentComment) {
        this.text = text;
        this.user = author;
        this.parentComment = parentComment;
    }
}
