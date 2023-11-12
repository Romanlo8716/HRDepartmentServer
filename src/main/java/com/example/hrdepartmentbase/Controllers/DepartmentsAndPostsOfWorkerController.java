package com.example.hrdepartmentbase.Controllers;

import com.example.hrdepartmentbase.Models.DepartmentsAndPostsOfWorker;
import com.example.hrdepartmentbase.Models.Post;
import com.example.hrdepartmentbase.Repository.DepartmentsAndPostsOfWorkerRepository;
import com.example.hrdepartmentbase.Repository.PostRepository;
import com.example.hrdepartmentbase.Services.DepartmentsAndPostsOfWorkerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "*")
public class DepartmentsAndPostsOfWorkerController {

    private final static Logger logger = LoggerFactory.getLogger(WorkerController.class);
    private DepartmentsAndPostsOfWorkerService departmentsAndPostsOfWorkerService;

    @Autowired
    public DepartmentsAndPostsOfWorkerController(DepartmentsAndPostsOfWorkerService departmentsAndPostsOfWorkerService) {
        this.departmentsAndPostsOfWorkerService = departmentsAndPostsOfWorkerService;
    }

    @GetMapping(value = "getGroupByDepartmentDepartmentsAndPostsOfWorker")
    public Iterable<DepartmentsAndPostsOfWorker> getGroupByDepartmentsAndPostsOfWorkers(){


        return  departmentsAndPostsOfWorkerService.getGroupByDepartmentsAndPostsOfWorkers();
    }

    @GetMapping(value = "getDepartmentsAndPostsOfWorker")
    public Iterable<DepartmentsAndPostsOfWorker> getAllDepartmentsAndPostsOfWorkers(){


        return  departmentsAndPostsOfWorkerService.getAllDepartmentsAndPostsOfWorkers();
    }


    @GetMapping(value = "getDepartmentsAndPostsOfWorkerByDepartmentId/{id}")
    public Iterable<DepartmentsAndPostsOfWorker> getDepartmentsAndPostsOfWorkerByDepartmentId(@PathVariable Long id){

        return  departmentsAndPostsOfWorkerService.getDepartmentsAndPostsOfWorkerByDepartmentId(id);
    }

    @GetMapping(value = "getDepartmentsAndPostsOfWorkerById/{id}")
    public Optional<DepartmentsAndPostsOfWorker> getDepartmentsAndPostsOfWorkerById(@PathVariable Long id){

        return  departmentsAndPostsOfWorkerService.getDepartmentsAndPostsOfWorkerById(id);
    }

    @DeleteMapping(value = "deleteDepartmentsAndPostsOfWorker/{id}")
    void deleteDepartmentsAndPostsOfWorkerById(@PathVariable Long id){
        departmentsAndPostsOfWorkerService.deleteDepartmentsAndPostsOfWorker(id);
    }


}
