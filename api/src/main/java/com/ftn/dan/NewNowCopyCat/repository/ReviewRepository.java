package com.ftn.dan.NewNowCopyCat.repository;

import com.ftn.dan.NewNowCopyCat.model.entity.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReviewRepository extends JpaRepository<Review, Long> {
    List<Review> findAllByLocation_Id(Long locationId);
}
