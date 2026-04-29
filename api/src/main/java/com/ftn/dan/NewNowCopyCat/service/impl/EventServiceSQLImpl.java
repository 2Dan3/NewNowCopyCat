package com.ftn.dan.NewNowCopyCat.service.impl;

import com.ftn.dan.NewNowCopyCat.model.entity.Event;
import com.ftn.dan.NewNowCopyCat.repository.EventRepository;
import com.ftn.dan.NewNowCopyCat.service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@Primary
public class EventServiceSQLImpl implements EventService {

    @Autowired
    private EventRepository eventRepository;


    @Override
    public List<Event> findAll() {
        return eventRepository.findAll();
    }

    @Override
    public Event findById(Long id) {
        return eventRepository.findById(id).orElse(null);
    }

    @Override
    public Integer countEventOccurencesAtLocation(Long locationId) {
        return eventRepository.countByLocationIdAndDateLessThan(locationId, LocalDate.now());
    }
}
