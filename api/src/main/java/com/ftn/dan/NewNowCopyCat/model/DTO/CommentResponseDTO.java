package com.ftn.dan.NewNowCopyCat.model.DTO;

import com.ftn.dan.NewNowCopyCat.model.entity.Comment;
import lombok.Getter;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
public class CommentResponseDTO {

    private Long id;
    private String text;
    private LocalDateTime createdAt;
    private Boolean hidden;

    private RateResponseDTO rate;
    private UserResponseDTO user;
    private EventResponseDTO event;
    private LocationResponseDTO location;
    private Long parentCommentId;
//    private ReviewResponseDTO review;

    public CommentResponseDTO(Comment c) {
        this.id = c.getId();
        this.text = c.getText();
        this.createdAt = c.getCreatedAt();
        this.hidden = c.getDeleted();

//        this.rate = new RateResponseDTO(c.getRate());
        this.user = new UserResponseDTO(c.getUser());
//        this.event = new EventResponseDTO(c.getEvent());
//        this.location = new LocationResponseDTO(c.getLocation());
        this.parentCommentId = c.getParentComment() != null ? c.getParentComment().getId() : null;
    }

}
