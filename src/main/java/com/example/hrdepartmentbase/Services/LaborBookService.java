package com.example.hrdepartmentbase.Services;

import com.example.hrdepartmentbase.Models.LaborBook;
import org.springframework.stereotype.Service;

import java.util.Optional;


public interface LaborBookService  {

    void addLaborBook(LaborBook laborBook);

    Optional<LaborBook> getLaborBookById(Long id);

    void deleteLaborBook(Long id);

    void updateLaborBook(Long id, LaborBook laborBook);
}
