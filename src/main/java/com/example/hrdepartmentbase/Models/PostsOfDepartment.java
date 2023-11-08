package com.example.hrdepartmentbase.Models;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class PostsOfDepartment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Post post;

    @ManyToOne
    private Department department;

    private int count;
}
