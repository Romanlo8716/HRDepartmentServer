package com.example.hrdepartmentbase.Models;


import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Data
@Entity
public class LaborBook {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false)
    private Date dateRecord;

    @Column(length = 50, nullable = false)
    private String nameWork;

    private String informationAboutWork;

    @Column(length = 30, nullable = false)
    private String nameDocument;

    @Column(nullable = false)
    private int numberDocument;

    @ManyToOne
    private Worker worker;
}
