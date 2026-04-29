package com.ftn.dan.NewNowCopyCat.model.DTO;

import com.ftn.dan.NewNowCopyCat.model.entity.User;
import lombok.Getter;

import java.time.LocalDate;

@Getter
public class UserResponseDTO {

    private Long id;
    private String email;
    private String name;
    private LocalDate createdAt;
    private String phoneNumber;
    private LocalDate birthday;
    private String address;
    private String city;

    private String role;
    private String avatarPath;

    public UserResponseDTO(User u) {
        this.id = u.getId();
        this.email = u.getEmail();
        this.name = u.getName();
        this.createdAt = u.getCreatedAt();
        this.phoneNumber = u.getPhoneNumber();
        this.birthday = u.getBirthday();
        this.address = u.getAddress();
        this.city = u.getCity();
        this.role = u.getRole();
        this.avatarPath = u.getImage().getPath();
    }
}