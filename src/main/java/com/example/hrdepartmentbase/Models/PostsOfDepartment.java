package com.example.hrdepartmentbase.Models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Data
@Entity
public class PostsOfDepartment {

    @Id
    private Long id;

    @ManyToOne
    private Post post;

    @ManyToOne
    private Department department;

    private int count;
}
