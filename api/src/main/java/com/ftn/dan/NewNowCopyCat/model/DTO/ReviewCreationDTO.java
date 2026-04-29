package com.ftn.dan.NewNowCopyCat.model.DTO;

import lombok.Data;

@Data
public class ReviewCreationDTO {

//    OPTIONAL
    private String commentText;

    private Integer performance;
    private Integer soundAndLighting;
    private Integer venue;
    private Integer overallImpression;

    private Long locationId;
    private Long eventId;
}
