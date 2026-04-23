package com.ftn.dan.NewNowCopyCat.model.entity;

import com.ftn.dan.NewNowCopyCat.model.enums.Roles;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;

@Entity
@Data
@RequiredArgsConstructor
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "role", discriminatorType = DiscriminatorType.STRING)
@DiscriminatorValue("USER")
public class User implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Long id;

    @Column
    private String email;

    @Column
    private String password;

    @Column
    private String name;

    @Column
    private LocalDate createdAt = LocalDate.now();

    @Column
    private String phoneNumber;

    @Column
    private LocalDate birthday;

    @Column
    private String address;

    @Column
    private String city;

    @OneToOne(fetch = FetchType.EAGER, mappedBy = "user")
    private Image image;

    @Column(nullable = false, insertable = false, updatable = false)
    @Enumerated(EnumType.STRING)
    private Roles role;

    @Transient
    public String getRole(){
        return this.getClass().getAnnotation(DiscriminatorValue.class).value();
    }

}
