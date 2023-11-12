package com.example.hrdepartmentbase.Services;

import com.example.hrdepartmentbase.Models.MedicalBook;
import com.example.hrdepartmentbase.Models.Vacation;

import java.util.Optional;

public interface VacationService {

    void addVacation(Vacation vacation);

    Optional<Vacation> getVacationById(Long id);

    void deleteVacation(Long id);

    void updateVacation(Long id, Vacation vacation);
}
