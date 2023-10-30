package com.example.hrdepartmentbase.Controllers;


import com.example.hrdepartmentbase.Models.AdressOfDepartment;
import com.example.hrdepartmentbase.Models.Post;
import com.example.hrdepartmentbase.Repository.AdressOfDepartmentRepository;
import com.example.hrdepartmentbase.Repository.PostRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@CrossOrigin(origins = "*")
public class AdressOfDepartmentController {
    private final static Logger logger = LoggerFactory.getLogger(WorkerController.class);
    private AdressOfDepartmentRepository adressOfDepartmentRepository;

    public AdressOfDepartmentController(AdressOfDepartmentRepository adressOfDepartmentRepository) {
        this.adressOfDepartmentRepository = adressOfDepartmentRepository;
    }

    @GetMapping(value = "getAdressOfDepartments")
    public Iterable<AdressOfDepartment> getAllAdressOfDepartments(){

        Iterable<AdressOfDepartment> adressOfDepartments = new ArrayList<>();
        adressOfDepartments = adressOfDepartmentRepository.findAll();
        return  adressOfDepartments;
    }

    @PostMapping(value = "createAdressOfDepartments")
    public void createAdressOfDepartments(@RequestBody AdressOfDepartment adressOfDepartment){

        adressOfDepartmentRepository.save(adressOfDepartment);
        logger.info("All records saved.");
    }
}
