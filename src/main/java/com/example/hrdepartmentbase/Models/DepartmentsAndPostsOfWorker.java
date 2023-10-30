package com.example.hrdepartmentbase.Models;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class DepartmentsAndPostsOfWorker {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Worker worker;

    @ManyToOne
    private Department department;

    @ManyToOne
    private Post post;


}
