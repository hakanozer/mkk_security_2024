package com.works.entities;

import com.works.customValid.StatusValid;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.Data;

@Entity
@Data
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long cid;

    @Size(min = 5, max = 100)
    @NotNull
    @NotEmpty
    //@Email
    @Column(length = 200)
    private String email;

    @Size(min = 5, max = 500)
    @NotEmpty
    @NotNull
    @Column(length = 500)
    private String password;

    @StatusValid
    @Column(length = 50)
    private String status;

}
