package com.example.hrdepartmentbase.Controllers;

import com.example.hrdepartmentbase.Models.DepartmentsAndPostsOfWorker;
import com.example.hrdepartmentbase.Models.Post;
import com.example.hrdepartmentbase.Repository.DepartmentsAndPostsOfWorkerRepository;
import com.example.hrdepartmentbase.Repository.PostRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
@CrossOrigin(origins = "*")
public class DepartmentsAndPostsOfWorkerController {

    private final static Logger logger = LoggerFactory.getLogger(WorkerController.class);
    private DepartmentsAndPostsOfWorkerRepository departmentsAndPostsOfWorkerRepository;

    @Autowired
    public DepartmentsAndPostsOfWorkerController(DepartmentsAndPostsOfWorkerRepository departmentsAndPostsOfWorkerRepository) {
        this.departmentsAndPostsOfWorkerRepository = departmentsAndPostsOfWorkerRepository;
    }

    @GetMapping(value = "getGroupByDepartmentDepartmentsAndPostsOfWorker")
    public Iterable<DepartmentsAndPostsOfWorker> getGroupByDepartmentsAndPostsOfWorkers(){

        Iterable<DepartmentsAndPostsOfWorker> departmentsAndPostsOfWorkers = new ArrayList<>();
        departmentsAndPostsOfWorkers = departmentsAndPostsOfWorkerRepository.groupByDepartment();
        return  departmentsAndPostsOfWorkers;
    }

    @GetMapping(value = "getDepartmentsAndPostsOfWorker")
    public Iterable<DepartmentsAndPostsOfWorker> getAllDepartmentsAndPostsOfWorkers(){

        Iterable<DepartmentsAndPostsOfWorker> departmentsAndPostsOfWorkers = new ArrayList<>();
        departmentsAndPostsOfWorkers = departmentsAndPostsOfWorkerRepository.findAll();
        return  departmentsAndPostsOfWorkers;
    }




}
