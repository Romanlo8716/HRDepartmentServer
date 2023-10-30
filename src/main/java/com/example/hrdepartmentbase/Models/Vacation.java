package com.example.hrdepartmentbase.Models;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.Data;

import java.util.Date;

@Data
@Entity
public class Vacation {

    @Id
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
