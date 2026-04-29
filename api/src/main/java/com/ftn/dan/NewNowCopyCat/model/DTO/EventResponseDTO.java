package com.ftn.dan.NewNowCopyCat.model.DTO;

import com.ftn.dan.NewNowCopyCat.model.entity.Event;
import lombok.Getter;

import java.time.LocalDate;

@Getter
public class EventResponseDTO {

    private Long id;

    private String name;

    private String address;

    private String type;

    private LocalDate date;
    
    private Double price;

    private Boolean recurrent;

    private String locationAddress;

    public EventResponseDTO(Event e) {
        this.id = e.getId();
        this.name = e.getName();
        this.address = e.getAddress();
        this.type = e.getType();
        this.date = e.getDate();
        this.price = e.getPrice();
        this.recurrent = e.getRecurrent();
        this.locationAddress = e.getLocation().getAddress();
    }
}
