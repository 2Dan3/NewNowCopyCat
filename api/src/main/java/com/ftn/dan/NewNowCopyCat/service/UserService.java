package com.ftn.dan.NewNowCopyCat.service;

import com.ftn.dan.NewNowCopyCat.model.DTO.ChangeDataUserDTO;
import com.ftn.dan.NewNowCopyCat.model.DTO.UserDTO;
import com.ftn.dan.NewNowCopyCat.model.DTO.UserRegistrationDTO;
import com.ftn.dan.NewNowCopyCat.model.entity.User;

import java.util.List;

public interface UserService {

    User findByEmail(String email);

//    User createUser(UserDTO userDTO);

    List<User> findAll();

    User findById(Long id);

    boolean changeOwnData(ChangeDataUserDTO newData, User currentUserData);

    boolean changeOwnPassword(String oldPassword, String newPassword, User foundUser);

    void remove(User foundUser);

    boolean isLoggedUser(User subjectUser);

    boolean moderatesLocation(Long locationId, User moderator);
//    TODO: use for checks in Web's configure()
//    boolean isUserBanned(User user, Community community);

    User save(User user);

    User createUser(UserRegistrationDTO newUser);
}
