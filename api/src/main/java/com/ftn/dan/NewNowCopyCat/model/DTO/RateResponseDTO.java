package com.ftn.dan.NewNowCopyCat.model.DTO;

import com.ftn.dan.NewNowCopyCat.model.entity.Rate;
import lombok.Getter;

@Getter
public class RateResponseDTO {

    private Long id;
    private Integer performance;
    private Integer soundAndLighting;
    private Integer venue;
    private Integer overallImpression;

    public RateResponseDTO(Rate r) {
        this.id = r.getId();
        this.performance = r.getPerformance();
        this.soundAndLighting = r.getSoundAndLighting();
        this.venue = r.getVenue();
        this.overallImpression = r.getOverallImpression();
    }
}
