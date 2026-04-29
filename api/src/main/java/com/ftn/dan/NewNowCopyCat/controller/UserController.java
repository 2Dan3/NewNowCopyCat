package com.ftn.dan.NewNowCopyCat.controller;

import com.ftn.dan.NewNowCopyCat.model.DTO.ChangeDataUserDTO;
import com.ftn.dan.NewNowCopyCat.model.DTO.JwtAuthenticationRequest;
import com.ftn.dan.NewNowCopyCat.model.DTO.UserDTO;
import com.ftn.dan.NewNowCopyCat.model.DTO.UserTokenState;
import com.ftn.dan.NewNowCopyCat.model.entity.User;
import com.ftn.dan.NewNowCopyCat.security.TokenUtils;
import com.ftn.dan.NewNowCopyCat.service.UserService;
import com.ftn.dan.NewNowCopyCat.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping(value = "/users")
public class UserController {

    private UserService userService;
    private UserDetailsService userDetailsService;
    private AuthenticationManager authenticationManager;
    private TokenUtils tokenUtils;

    @Autowired
    public UserController(UserServiceImpl userService, AuthenticationManager authenticationManager,
                          UserDetailsService userDetailsService, TokenUtils tokenUtils){
        this.userService = userService;
        this.authenticationManager = authenticationManager;
        this.userDetailsService = userDetailsService;
        this.tokenUtils = tokenUtils;
    }

    @PostMapping(consumes = "application/json", value = "/")
    public ResponseEntity<UserDTO> registerNewUser(@Valid @RequestBody UserDTO newUser){

        User createdUser = userService.createUser(newUser);

        if(createdUser == null){
            return new ResponseEntity<>(null, HttpStatus.NOT_ACCEPTABLE);
        }
        UserDTO userDTO = new UserDTO(createdUser);

        return new ResponseEntity<>(userDTO, HttpStatus.CREATED);
    }

    //    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping(consumes = "application/json", value = "/login")
    public ResponseEntity<UserTokenState> createAuthenticationToken(
            @Valid @RequestBody JwtAuthenticationRequest authRequest, HttpServletResponse response) {
        System.out.println("\n------------\nENTERED LOGIN\n------------\n");

        UsernamePasswordAuthenticationToken authenticationToken =
                new UsernamePasswordAuthenticationToken(
                        authRequest.getUsername(), authRequest.getPassword() );
        // Ukoliko kredencijali nisu ispravni, logovanje nece biti uspesno, desice se
        // AuthenticationException
        Authentication authentication = authenticationManager.authenticate(authenticationToken);

        // Ukoliko je autentifikacija uspesna, ubaci korisnika u trenutni security
        // kontekst
        SecurityContextHolder.getContext().setAuthentication(authentication);

        // Kreiraj token za tog korisnika
//        UserDetails user = (UserDetails) authentication.getPrincipal();  ILI
        try {
            UserDetails user = userDetailsService.loadUserByUsername(authRequest.getUsername());
            String jwt = tokenUtils.generateToken(user);
            int expiresIn = tokenUtils.getExpiredIn();

            // Vrati token kao odgovor na uspesnu autentifikaciju
            return new ResponseEntity<>(new UserTokenState(jwt, expiresIn), HttpStatus.OK);
        }
        catch (UsernameNotFoundException e) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/all")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<List<UserDTO>> loadAll() {
        List<User> users = this.userService.findAll();

        // convert users to userDTOs
        List<UserDTO> usersDTO = new ArrayList<>();
        for (User u : users) {
            usersDTO.add(new UserDTO(u));
        }

        return new ResponseEntity<>(usersDTO, HttpStatus.OK);
    }

    @GetMapping("/whoami")
    @PreAuthorize("hasAnyRole('USER', 'ADMIN')")
    public ResponseEntity<UserDTO> user(Authentication user) {
        User foundUser = this.userService.findByEmail(user.getName());
        return new ResponseEntity<>(new UserDTO(foundUser), HttpStatus.OK);
    }


    @GetMapping("/{id}")
    @PreAuthorize("hasAnyRole('USER', 'ADMIN')")
    public ResponseEntity<UserDTO> getUser(@PathVariable Long id) {
        User foundUser = this.userService.findById(id);

        if (foundUser == null) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<UserDTO>(new UserDTO(foundUser), HttpStatus.OK);
    }

    @PutMapping("/")
    @PreAuthorize("hasAnyRole('USER', 'ADMIN')")
    public ResponseEntity<Void> changeOwnPassword(Authentication loggedUser, @RequestBody @NotBlank HashMap<String, String> passwords) {
//        if (password == null || "".equals(password.trim()))
        if (passwords == null || passwords.isEmpty())
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);

        User subjectUser = userService.findByEmail(loggedUser.getName());

        if (subjectUser == null)
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);

        boolean passwordChangeSuccessful = userService.changeOwnPassword(passwords.get("oldPass"), passwords.get("newPass"), subjectUser);
        if (!passwordChangeSuccessful)
            return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("/edit")
    @PreAuthorize("hasAnyRole('USER', 'ADMIN')")
    public ResponseEntity<UserDTO> changeOwnData(Authentication loggedUser, @Valid @RequestBody ChangeDataUserDTO newData) {
        User foundUser = userService.findByEmail(loggedUser.getName() );

        if (foundUser == null)
            return new ResponseEntity<>(null, HttpStatus.UNAUTHORIZED);

        if (userService.changeOwnData(newData, foundUser) == false)
            return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);

        return new ResponseEntity<>(new UserDTO(foundUser), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<String> removeUser(@PathVariable Long id) {
        User foundUser = userService.findById(id);
        if(foundUser == null) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
        userService.remove(foundUser);
        return new ResponseEntity<>(null, HttpStatus.OK);
    }

    @PostMapping(value = "/logout")
    public ResponseEntity<Void> invalidateToken() {
        // TODO:
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
