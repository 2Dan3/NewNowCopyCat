package com.ftn.dan.NewNowCopyCat.model.DTO;

import com.ftn.dan.NewNowCopyCat.model.entity.Location;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Getter
@NoArgsConstructor
public class LocationResponseDTO {

    private Long id;
    private String name;
    private String description;
    private LocalDate createdAt;
    private String address;
    private Double totalRating;
    private String type;
    private String imagePath;

    public LocationResponseDTO(Location location) {
        this.id = location.getId();
        this.name = location.getName();
        this.description = location.getDescription();
        this.createdAt = location.getCreatedAt();
        this.address = location.getAddress();
        this.totalRating = location.getTotalRating();
        this.type = location.getType();
        this.imagePath = location.getImage() != null ? location.getImage().getPath() : null;
    }
}
