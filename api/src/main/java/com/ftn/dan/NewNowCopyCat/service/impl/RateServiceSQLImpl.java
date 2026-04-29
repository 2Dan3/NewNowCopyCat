package com.ftn.dan.NewNowCopyCat.service.impl;

import com.ftn.dan.NewNowCopyCat.repository.RateRepository;
import com.ftn.dan.NewNowCopyCat.service.RateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

@Service
@Primary
public class RateServiceSQLImpl implements RateService {

    @Autowired
    private RateRepository rateRepository;


}
