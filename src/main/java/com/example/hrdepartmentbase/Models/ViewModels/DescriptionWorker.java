package com.example.hrdepartmentbase.Models.ViewModels;


import com.example.hrdepartmentbase.Models.*;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import lombok.Data;

import java.util.List;

@Data
@Entity

public class DescriptionWorker {

    @Id
    private Long id;

    @OneToOne
    private Worker worker;

    @OneToMany
    private List<LaborBook> laborBooks;

    @OneToMany
    private List<MedicalBook> medicalBooks;

    @OneToMany
    private List<Education> educations;

    @OneToMany
    private List<Vacation> vacations;

    @OneToMany
    private List<DepartmentsAndPostsOfWorker> departmentsAndPostsOfWorkers;



}
