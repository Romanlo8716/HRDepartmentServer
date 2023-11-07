package com.example.hrdepartmentbase.Controllers;


import com.example.hrdepartmentbase.Models.AdressOfDepartment;
import com.example.hrdepartmentbase.Models.Department;
import com.example.hrdepartmentbase.Models.Post;
import com.example.hrdepartmentbase.Repository.AdressOfDepartmentRepository;
import com.example.hrdepartmentbase.Repository.PostRepository;
import com.example.hrdepartmentbase.Services.AdressOfDepartmentService;
import com.example.hrdepartmentbase.Services.AdressOfDepartmentServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "*")
public class AdressOfDepartmentController {
    private final static Logger logger = LoggerFactory.getLogger(WorkerController.class);
    private AdressOfDepartmentServiceImpl adressOfDepartmentService;

    public AdressOfDepartmentController(AdressOfDepartmentServiceImpl adressOfDepartmentService) {
        this.adressOfDepartmentService = adressOfDepartmentService;
    }

    @GetMapping(value = "getAdressOfDepartments")
    public Iterable<AdressOfDepartment> getAllAdressOfDepartments(){


        return  adressOfDepartmentService.getAllAdressOfDepartments();
    }

    @GetMapping(value = "getAdressOfDepartmentById/{id}")
    public Optional<AdressOfDepartment> getAdressOfDepartmentById(@PathVariable Long id){


        return  adressOfDepartmentService.getAdressOfDepartmentById(id);
    }

    @PostMapping(value = "createAdressOfDepartments")
    public void createAdressOfDepartments(@RequestBody AdressOfDepartment adressOfDepartment){

     adressOfDepartmentService.createAdressOfDepartments(adressOfDepartment);
    }

    @DeleteMapping(value = "deleteAdressOfDepartment/{id}")
    public void deleteAdressOfDepartment(@PathVariable Long id){
       adressOfDepartmentService.deleteAdressOfDepartment(id);
    }

    @PutMapping(value = "updateAdressOfDepartment/{id}")
    public void updateAdressOfDepartment(@PathVariable Long id, @RequestBody AdressOfDepartment adressOfDepartment){
        adressOfDepartmentService.updateAdressOfDepartment(id,adressOfDepartment);
    }
}
