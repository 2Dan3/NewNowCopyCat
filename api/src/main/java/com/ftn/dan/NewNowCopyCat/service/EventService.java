package com.ftn.dan.NewNowCopyCat.service;

import com.ftn.dan.NewNowCopyCat.model.entity.Event;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface EventService {
    List<Event> findAll();

    Event findById(Long id);

    Integer countEventOccurencesAtLocation(Long locationId);
}
