package com.example.hrdepartmentbase.Models;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.Data;

import java.util.Date;

@Data
@Entity
public class MedicalBook {

    @Id
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
