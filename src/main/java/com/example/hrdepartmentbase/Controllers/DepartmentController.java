package com.example.hrdepartmentbase.Controllers;

import com.example.hrdepartmentbase.Models.Department;
import com.example.hrdepartmentbase.Models.Post;
import com.example.hrdepartmentbase.Repository.DepartmentRepository;
import com.example.hrdepartmentbase.Repository.PostRepository;
import com.example.hrdepartmentbase.Services.DepartmentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Optional;


@RestController
@CrossOrigin(origins = "*")
public class DepartmentController {

    private final static Logger logger = LoggerFactory.getLogger(WorkerController.class);
    private DepartmentService departmentService;

    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @GetMapping(value = "getDepartments")
    public Iterable<Department> getAllDepartments(){

        return  departmentService.getAllDepartments();
    }

    @GetMapping(value = "getDepartmentById/{id}")
    public Optional<Department> getDepartmentsById(@PathVariable Long id){

        return  departmentService.getDepartmentsById(id);
    }

    @PostMapping(value = "createDepartments")
    public void createDepartments(@RequestBody Department department){

       departmentService.createDepartments(department);
    }

    @DeleteMapping(value = "deleteDepartment/{id}")
    public void deleteDepartment(@PathVariable Long id){
        departmentService.deleteDepartment(id);
    }

    @PutMapping(value = "updateDepartment/{id}")
    public void updateDepartment(@PathVariable Long id, @RequestBody Department department){
        departmentService.updateDepartment(id,department);
    }


}
