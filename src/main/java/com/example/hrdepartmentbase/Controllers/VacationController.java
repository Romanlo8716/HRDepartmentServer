package com.example.hrdepartmentbase.Controllers;


import com.example.hrdepartmentbase.Models.LaborBook;
import com.example.hrdepartmentbase.Models.MedicalBook;
import com.example.hrdepartmentbase.Models.Vacation;
import com.example.hrdepartmentbase.Services.VacationService;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@CrossOrigin(origins = "*")
public class VacationController {

    public VacationController(VacationService vacationService) {
        this.vacationService = vacationService;
    }

    VacationService vacationService;

    @PostMapping(value = "addVacation")
    void addVacation(@RequestBody Vacation vacation){
        vacationService.addVacation(vacation);
    }

    @GetMapping(value = "getVacationById/{id}")
    Optional<Vacation> getVacationById(@PathVariable Long id){
        return vacationService.getVacationById(id);
    }

    @DeleteMapping(value = "deleteVacation/{id}")
    void deleteVacation(@PathVariable Long id){
        vacationService.deleteVacation(id);
    }

    @PutMapping(value = "updateVacation/{id}")
    void updateVacation(@PathVariable Long id, @RequestBody Vacation vacation){
        vacationService.updateVacation(id, vacation);
    }
}
