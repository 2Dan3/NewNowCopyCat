package com.ftn.dan.NewNowCopyCat.repository;

import com.ftn.dan.NewNowCopyCat.model.entity.Manages;
import com.ftn.dan.NewNowCopyCat.model.entity.ManagesId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ManagesRepository extends JpaRepository<Manages, ManagesId> {

    boolean existsByIdUserIdAndIdLocationId(Long userId, Long LocationId);

}
