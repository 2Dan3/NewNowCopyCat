package com.ftn.dan.NewNowCopyCat.service;

import com.ftn.dan.NewNowCopyCat.model.entity.Location;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface LocationService {
    List<Location> findAll();

    Location findById(Long id);
}
