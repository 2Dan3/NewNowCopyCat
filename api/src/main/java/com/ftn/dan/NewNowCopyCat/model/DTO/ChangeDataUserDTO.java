package com.ftn.dan.NewNowCopyCat.model.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ChangeDataUserDTO {

    private String name;
    private String phoneNumber;
    private LocalDate birthday;
    private String address;
    private String city;
}
