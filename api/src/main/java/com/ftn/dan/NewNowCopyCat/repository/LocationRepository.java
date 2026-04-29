package com.ftn.dan.NewNowCopyCat.repository;

import com.ftn.dan.NewNowCopyCat.model.entity.Location;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LocationRepository extends JpaRepository<Location, Long> {


}
