package com.ftn.dan.NewNowCopyCat.model.DTO;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

public record UserRegistrationDTO(

//    private static Long id;

    @NotBlank
    @Email(message = "Invalid email format", regexp = ".+[@].+[\\.].+")
    String email,

    @NotBlank
    String password,

    @NotBlank
    String address

//    private static String name;
//
//    private static String phoneNumber;
//
//    private static LocalDate birthday;
//
//    private static String city;
//
//    private static MultipartFile image;
) {}
