package com.example.hrdepartmentbase.Services;

import com.example.hrdepartmentbase.Models.Education;
import com.example.hrdepartmentbase.Models.LaborBook;

import java.util.Optional;

public interface EducationService {

    void addEducation(Education education);

    Optional<Education> getEducationById(Long id);

    void deleteEducation(Long id);

    void updateEducation(Long id, Education education);
}
