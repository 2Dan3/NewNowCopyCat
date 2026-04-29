package com.ftn.dan.NewNowCopyCat.model.DTO;

import com.ftn.dan.NewNowCopyCat.model.entity.Review;
import lombok.Getter;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
public class ReviewResponseDTO {

    private Long id;
    private LocalDateTime createdAt;
    private Integer eventCount;
    private Boolean hidden;

    private RateResponseDTO rate;
    private LocationResponseDTO location;
    private EventResponseDTO event;
    private CommentResponseDTO comment;
    private UserResponseDTO user;

    public ReviewResponseDTO(Review r) {
        this.id = r.getId();
        this.createdAt = r.getCreatedAt();
        this.eventCount = r.getEventCount();
        this.hidden = r.getHidden();
        this.rate = new RateResponseDTO(r.getRate());
        this.location = new LocationResponseDTO(r.getLocation());
        this.event = new EventResponseDTO(r.getEvent());
        this.comment = new CommentResponseDTO(r.getComment());
        this.user = new UserResponseDTO(r.getUser());
    }
}
