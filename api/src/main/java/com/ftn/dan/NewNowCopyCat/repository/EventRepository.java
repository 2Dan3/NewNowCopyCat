package com.ftn.dan.NewNowCopyCat.repository;

import com.ftn.dan.NewNowCopyCat.model.entity.Event;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;

@Repository
public interface EventRepository extends JpaRepository<Event, Long> {

    Integer countByLocationIdAndDateLessThan(Long locationId, LocalDate date);
}
