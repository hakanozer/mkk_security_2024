package com.works.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.Data;

@Entity
@Data
public class Product extends Base {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer pid;

    @Size(min = 2, max = 100)
    @NotEmpty
    @NotNull
    private String title;

    @Max(100000)
    @Min(1)
    @Column(nullable = false)
    private int price;

}
