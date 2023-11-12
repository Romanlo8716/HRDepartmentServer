package com.example.hrdepartmentbase.Models;


import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Data
@Entity
public class MedicalBook {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(length = 50, nullable = false)
    private String placeExam;

    @Column(nullable = false)
    private Date dateExam;

    @Column(length = 50, nullable = false)
    private String conclusion;

    @ManyToOne
    private Worker worker;
}
