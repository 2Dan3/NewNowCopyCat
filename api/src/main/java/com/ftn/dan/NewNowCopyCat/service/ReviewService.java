package com.ftn.dan.NewNowCopyCat.service;

import com.ftn.dan.NewNowCopyCat.model.DTO.ReviewCreationDTO;
import com.ftn.dan.NewNowCopyCat.model.entity.Review;
import com.ftn.dan.NewNowCopyCat.model.entity.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ReviewService {
    Review save(Review review);

    List<Review> findAll();

    List<Review> findAllByLocation_Id(Long locationId);

    Review createReview(ReviewCreationDTO dto, User loggedUser) throws Exception;
}
