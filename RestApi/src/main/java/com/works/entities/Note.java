package com.works.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Note extends Base {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer nid;

    private String title;
    private String detail;


}
