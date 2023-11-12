package com.example.hrdepartmentbase.Services;

import com.example.hrdepartmentbase.Models.LaborBook;
import com.example.hrdepartmentbase.Models.MedicalBook;

import java.util.Optional;

public interface MedicalBookService {

    void addMedicalBook(MedicalBook medicalBook);

    Optional<MedicalBook> getMedicalBookById(Long id);

    void deleteMedicalBook(Long id);

    void updateMedicalBook(Long id, MedicalBook medicalBook);
}
