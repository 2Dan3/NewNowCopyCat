package com.ftn.dan.NewNowCopyCat.controller;

import com.ftn.dan.NewNowCopyCat.model.DTO.EventResponseDTO;
import com.ftn.dan.NewNowCopyCat.model.DTO.LocationResponseDTO;
import com.ftn.dan.NewNowCopyCat.model.entity.Event;
import com.ftn.dan.NewNowCopyCat.model.entity.Location;
import com.ftn.dan.NewNowCopyCat.security.TokenUtils;
import com.ftn.dan.NewNowCopyCat.service.LocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/locations")
public class LocationController {

    private LocationService LocationService;
    private AuthenticationManager authenticationManager;

    @Autowired
    public LocationController(LocationService LocationService, AuthenticationManager authenticationManager){
        this.LocationService = LocationService;
        this.authenticationManager = authenticationManager;
    }

    @GetMapping
//    @ResponseStatus(HttpStatus.OK)
//    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<List<LocationResponseDTO>> getLocations() {
        List<Location> locations = this.LocationService.findAll();

        List<LocationResponseDTO> locationDTOs = new ArrayList<>();
        for (Location l : locations) {
            locationDTOs.add(new LocationResponseDTO(l));
        }

        return new ResponseEntity<>(locationDTOs, HttpStatus.OK);
    }

}
