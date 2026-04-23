package com.ftn.dan.NewNowCopyCat.model.entity;

import com.ftn.dan.NewNowCopyCat.model.enums.RequestStatus;
import lombok.Data;
import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Data
public class AccountRequest {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String email;

    @Column
    private String password;

    @Column
    private String address;

    @Column
    private RequestStatus status = RequestStatus.PENDING;

    @Column
    private LocalDate createdAt = LocalDate.now();

    @Column
    private String rejectionReason;
}
