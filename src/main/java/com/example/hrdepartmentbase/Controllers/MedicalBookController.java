package com.example.hrdepartmentbase.Controllers;

import com.example.hrdepartmentbase.Models.LaborBook;
import com.example.hrdepartmentbase.Models.MedicalBook;
import com.example.hrdepartmentbase.Models.Vacation;
import com.example.hrdepartmentbase.Services.MedicalBookService;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@CrossOrigin(origins = "*")
public class MedicalBookController {

    public MedicalBookController(MedicalBookService medicalBookService) {
        this.medicalBookService = medicalBookService;
    }

    MedicalBookService medicalBookService;

    @PostMapping(value = "addMedicalBook")
    void addMedicalBook(@RequestBody MedicalBook medicalBook){
        medicalBookService.addMedicalBook(medicalBook);
    }

    @GetMapping(value = "getMedicalBookById/{id}")
    Optional<MedicalBook> getMedicalBookById(@PathVariable Long id){
        return medicalBookService.getMedicalBookById(id);
    }

    @DeleteMapping(value = "deleteMedicalBook/{id}")
    void deleteMedicalBook(@PathVariable Long id){
        medicalBookService.deleteMedicalBook(id);
    }

    @PutMapping(value = "updateMedicalBook/{id}")
    void updateMedicalBook(@PathVariable Long id, @RequestBody MedicalBook medicalBook){
        medicalBookService.updateMedicalBook(id, medicalBook);
    }
}
