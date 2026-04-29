package com.ftn.dan.NewNowCopyCat.repository;

import com.ftn.dan.NewNowCopyCat.model.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Long> {
}
