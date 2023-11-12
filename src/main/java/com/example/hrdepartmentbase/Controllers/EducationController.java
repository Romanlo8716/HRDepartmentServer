package com.example.hrdepartmentbase.Controllers;

import com.example.hrdepartmentbase.Models.Education;
import com.example.hrdepartmentbase.Models.LaborBook;
import com.example.hrdepartmentbase.Services.EducationService;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@CrossOrigin(origins = "*")
public class EducationController {

    EducationService educationService;

    public EducationController(EducationService educationService) {
        this.educationService = educationService;
    }

    @PostMapping(value = "addEducation")
    void addEducation(@RequestBody Education education){
        educationService.addEducation(education);
    }

    @GetMapping(value = "getEducationById/{id}")
    Optional<Education> getEducationById(@PathVariable Long id){
        return educationService.getEducationById(id);
    }

    @DeleteMapping(value = "deleteEducation/{id}")
    void deleteEducation(@PathVariable Long id){
        educationService.deleteEducation(id);
    }

    @PutMapping(value = "updateEducation/{id}")
    void updateEducation(@PathVariable Long id, @RequestBody Education education){
        educationService.updateEducation(id, education);
    }
}
