package com.ftn.dan.NewNowCopyCat.controller;

import com.ftn.dan.NewNowCopyCat.model.DTO.ReviewCreationDTO;
import com.ftn.dan.NewNowCopyCat.model.DTO.ReviewResponseDTO;
import com.ftn.dan.NewNowCopyCat.model.entity.Review;
import com.ftn.dan.NewNowCopyCat.model.entity.User;
import com.ftn.dan.NewNowCopyCat.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/reviews")
public class ReviewController {

    private ReviewService reviewService;
    private CommentService commentService;
    private RateService rateService;
    private UserService userService;
    private LocationService locationService;
    private EventService eventService;

    @Autowired
    public ReviewController(
            ReviewService reviewService,
            CommentService commentService,
            RateService rateService,
            UserService userService,
            LocationService locationService,
            EventService eventService) {

        this.reviewService = reviewService;
        this.commentService = commentService;
        this.rateService = rateService;
        this.userService = userService;
        this.locationService = locationService;
        this.eventService = eventService;
    }


    @GetMapping
    public ResponseEntity<List<ReviewResponseDTO>> getReviews(@PathVariable(name = "location_id", required = false) Long locationID) {

        List<Review> reviewsFound;
        final List<ReviewResponseDTO> reviewDTOs = new ArrayList<>();

        if (locationID == null)
            reviewsFound = reviewService.findAll();
        else
            reviewsFound = reviewService.findAllByLocation_Id(locationID);

        for (Review r : reviewsFound) {
            reviewDTOs.add(new ReviewResponseDTO(r));
        }

        return new ResponseEntity<>(reviewDTOs, HttpStatus.OK);
    }

    @PostMapping("/")
    public ResponseEntity<Long> reviewLocation(@RequestBody ReviewCreationDTO reviewCreationDTO, Authentication auth) {
        User loggedUser = userService.findByEmail(auth.getName());
        if (loggedUser == null)
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();

        try {
            Review newReview = reviewService.createReview(reviewCreationDTO, loggedUser);
            return new ResponseEntity<>(newReview.getId(), HttpStatus.CREATED);

        }catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

}
