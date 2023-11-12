package com.example.hrdepartmentbase.Models;


import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Data
@Entity
public class Vacation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(length = 50, nullable = false)
    private String typeVacation;

    @Column(nullable = false)
    private Date dateStartVacation;

    @Column(nullable = false)
    private Date dateEndVacation;

    @Column(length = 50, nullable = false)
    private String footing;

    @ManyToOne
    private Worker worker;
}
