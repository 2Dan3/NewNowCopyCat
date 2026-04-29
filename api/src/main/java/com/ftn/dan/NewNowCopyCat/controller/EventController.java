package com.ftn.dan.NewNowCopyCat.controller;

import com.ftn.dan.NewNowCopyCat.model.DTO.EventResponseDTO;
import com.ftn.dan.NewNowCopyCat.model.entity.Event;
import com.ftn.dan.NewNowCopyCat.security.TokenUtils;
import com.ftn.dan.NewNowCopyCat.service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/events")
public class EventController {

    private EventService eventService;
    private AuthenticationManager authenticationManager;
    private TokenUtils tokenUtils;

    @Autowired
    public EventController(EventService eventService, AuthenticationManager authenticationManager,
                           TokenUtils tokenUtils){
        this.eventService = eventService;
        this.authenticationManager = authenticationManager;
        this.tokenUtils = tokenUtils;
    }

    @GetMapping
//    @ResponseStatus(HttpStatus.OK)
//    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<List<EventResponseDTO>> loadAll() {
        List<Event> events = this.eventService.findAll();

        List<EventResponseDTO> eventDTOs = new ArrayList<>();
        for (Event e : events) {
            eventDTOs.add(new EventResponseDTO(e));
        }

        return new ResponseEntity<>(eventDTOs, HttpStatus.OK);
    }

}
