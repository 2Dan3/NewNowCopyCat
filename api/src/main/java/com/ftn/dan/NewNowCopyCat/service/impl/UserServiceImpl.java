package com.ftn.dan.NewNowCopyCat.service.impl;

import com.ftn.dan.NewNowCopyCat.model.DTO.ChangeDataUserDTO;
import com.ftn.dan.NewNowCopyCat.model.DTO.UserDTO;
import com.ftn.dan.NewNowCopyCat.model.entity.User;
import com.ftn.dan.NewNowCopyCat.model.enums.Roles;
import com.ftn.dan.NewNowCopyCat.repository.ManagesRepository;
import com.ftn.dan.NewNowCopyCat.repository.UserRepository;
import com.ftn.dan.NewNowCopyCat.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;

    private ManagesRepository managesRepository;

    private PasswordEncoder passwordEncoder;


    @Autowired
    public UserServiceImpl(@Lazy PasswordEncoder passwordEnc, UserRepository userRepository, ManagesRepository managesRepository) {
        this.passwordEncoder = passwordEnc;
        this.managesRepository = managesRepository;
        this.userRepository = userRepository;
    }

//    public User findByUsername(String username) {
//        Optional<User> user = userRepository.findFirstByEmail(username);
//        if (!user.isEmpty()) {
//            return user.get();
//        }
//        return null;
//    }

    @Override
    public User createUser(UserDTO userDTO) {

        if ( existsForEmail(userDTO.getEmail()) ) {
            return null;
        }

        User newUser = new User();
        newUser.setEmail(userDTO.getEmail().trim() );
        newUser.setPassword(passwordEncoder.encode(userDTO.getPassword()));
        newUser.setRole(Roles.USER);
//todo all that set (opt image too)
        newUser = userRepository.save(newUser);

        return newUser;
    }

    private boolean existsForEmail(String email) {
        return userRepository.findFirstByEmail(email).isPresent();
    }

    @Override
    public User findByEmail(String email) {
        Optional<User> found = userRepository.findFirstByEmail(email);
        return found.orElse(null);
    }

    @Override
    public List<User> findAll() {
        return this.userRepository.findAll();
    }

    public User findById(Long id) {
        return this.userRepository.findById(id).orElse(null);
    }

    //    todo
    @Override
    public boolean changeOwnData(ChangeDataUserDTO newData, User currentUser) {

        currentUser.setName(newData.getName().trim());
        currentUser.setPhoneNumber(newData.getPhoneNumber().trim());
        currentUser.setBirthday(newData.getBirthday());
        currentUser.setAddress(newData.getAddress().trim());
        currentUser.setCity(newData.getCity().trim());

        userRepository.save(currentUser);
        return true;
    }

    private boolean emailBelongsToUser(String newEmail, String existingUserEmail) {
        return existingUserEmail.equalsIgnoreCase(newEmail.trim() );
    }

    private boolean emailIsTaken(String newEmail) {
        return userRepository.findFirstByEmail(newEmail).isPresent();
    }

    @Override
    public boolean changeOwnPassword(String oldPassword, String newPassword, User foundUser) {
        if (!passwordEncoder.matches(oldPassword, foundUser.getPassword()) )
            return false;
        foundUser.setPassword(passwordEncoder.encode(newPassword));
        userRepository.save(foundUser);
        return true;
    }

    @Override
    public void remove(User foundUser) {
        userRepository.delete(foundUser);
    }

    @Override
    public boolean isLoggedUser(User subjectUser) {
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String emailOfLogged;

        if (principal instanceof UserDetails) {
            emailOfLogged = ((UserDetails)principal).getUsername();
        } else {
            emailOfLogged = principal.toString();
        }

        if (subjectUser.getEmail().equals(emailOfLogged))
            return true;
        return false;
    }

    @Override
    public boolean moderatesLocation(Long locationId, User moderator) {
        return managesRepository.existsByIdUserIdAndIdLocationId(moderator.getId(), locationId);
    }

    @Override
    public User save(User user) {
        return this.userRepository.save(user);
    }

}
