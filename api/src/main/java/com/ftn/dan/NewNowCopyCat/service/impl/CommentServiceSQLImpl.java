package com.ftn.dan.NewNowCopyCat.service.impl;

import com.ftn.dan.NewNowCopyCat.repository.CommentRepository;
import com.ftn.dan.NewNowCopyCat.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

@Service
@Primary
public class CommentServiceSQLImpl implements CommentService {

    @Autowired
    private CommentRepository commentRepository;


}
