package com.ftn.dan.NewNowCopyCat.service.impl;

import com.ftn.dan.NewNowCopyCat.model.DTO.ReviewCreationDTO;
import com.ftn.dan.NewNowCopyCat.model.entity.*;
import com.ftn.dan.NewNowCopyCat.repository.ReviewRepository;
import com.ftn.dan.NewNowCopyCat.service.CommentService;
import com.ftn.dan.NewNowCopyCat.service.EventService;
import com.ftn.dan.NewNowCopyCat.service.LocationService;
import com.ftn.dan.NewNowCopyCat.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Primary
public class ReviewServiceSQLImpl implements ReviewService {

    @Autowired
    private ReviewRepository reviewRepository;
    @Autowired
    private EventService eventService;
    @Autowired
    private LocationService locationService;
    @Autowired
    private CommentService commentService;


    @Override
    public Review save(Review review) {
        return reviewRepository.save(review);
    }

    @Override
    public List<Review> findAll() {
        return reviewRepository.findAll();
    }

    @Override
    public List<Review> findAllByLocation_Id(Long locationId) {
        return reviewRepository.findAllByLocation_Id(locationId);
    }

    @Transactional
    @Override
    public Review createReview(ReviewCreationDTO dto, User user) throws Exception {

        try {
            Integer eventCount = eventService.countEventOccurencesAtLocation(dto.getLocationId());

            Rate rate = new Rate(dto.getPerformance(), dto.getSoundAndLighting(), dto.getVenue(), dto.getOverallImpression());

            Location location = locationService.findById(dto.getLocationId());

            Event event = eventService.findById(dto.getEventId());

            Comment comment = new Comment(dto.getCommentText(), user, null);

            Review r = new Review(eventCount, rate, location, event, comment, user);

            return reviewRepository.save(r);
        }catch (Exception e) {
            throw e;
        }
    }
}
