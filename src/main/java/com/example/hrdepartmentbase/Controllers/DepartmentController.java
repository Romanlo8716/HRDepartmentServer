package com.example.hrdepartmentbase.Controllers;

import com.example.hrdepartmentbase.Models.Department;
import com.example.hrdepartmentbase.Models.Post;
import com.example.hrdepartmentbase.Repository.DepartmentRepository;
import com.example.hrdepartmentbase.Repository.PostRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Optional;


@RestController
@CrossOrigin(origins = "*")
public class DepartmentController {

    private final static Logger logger = LoggerFactory.getLogger(WorkerController.class);
    private DepartmentRepository departmentRepository;

    public DepartmentController(DepartmentRepository departmentRepository) {
        this.departmentRepository = departmentRepository;
    }

    @GetMapping(value = "getDepartments")
    public Iterable<Department> getAllDepartments(){

        Iterable<Department> departments = new ArrayList<>();
        departments = departmentRepository.findAll();
        return  departments;
    }

    @GetMapping(value = "getDepartmentById/{id}")
    public Optional<Department> getDepartmentsById(@PathVariable Long id){

       Optional<Department> department = departmentRepository.findById(id);
        return  department;
    }

    @PostMapping(value = "createDepartments")
    public void createDepartments(@RequestBody Department department){

        departmentRepository.save(department);
        logger.info("All records saved.");
    }


}
