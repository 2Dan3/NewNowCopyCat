package com.ftn.dan.NewNowCopyCat.model.entity;

import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
@Data
@RequiredArgsConstructor
public class ManagesId implements Serializable {

    private Long userId;
    private Long locationId;
}
