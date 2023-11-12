package com.example.hrdepartmentbase.Services;

import com.example.hrdepartmentbase.Controllers.WorkerController;
import com.example.hrdepartmentbase.Models.DepartmentsAndPostsOfWorker;
import com.example.hrdepartmentbase.Repository.DepartmentsAndPostsOfWorkerRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class DepartmentsAndPostsOfWorkerServiceImpl implements DepartmentsAndPostsOfWorkerService{

    private final static Logger logger = LoggerFactory.getLogger(WorkerController.class);
    private DepartmentsAndPostsOfWorkerRepository departmentsAndPostsOfWorkerRepository;

    @Autowired
    public DepartmentsAndPostsOfWorkerServiceImpl(DepartmentsAndPostsOfWorkerRepository departmentsAndPostsOfWorkerRepository) {
        this.departmentsAndPostsOfWorkerRepository = departmentsAndPostsOfWorkerRepository;
    }

    @Override
    public Iterable<DepartmentsAndPostsOfWorker> getGroupByDepartmentsAndPostsOfWorkers(){

        Iterable<DepartmentsAndPostsOfWorker> departmentsAndPostsOfWorkers = new ArrayList<>();
        departmentsAndPostsOfWorkers = departmentsAndPostsOfWorkerRepository.groupByDepartment();
        return  departmentsAndPostsOfWorkers;
    }

    @Override
    public Iterable<DepartmentsAndPostsOfWorker> getAllDepartmentsAndPostsOfWorkers(){

        Iterable<DepartmentsAndPostsOfWorker> departmentsAndPostsOfWorkers = new ArrayList<>();
        departmentsAndPostsOfWorkers = departmentsAndPostsOfWorkerRepository.findAll();
        return  departmentsAndPostsOfWorkers;
    }


    @Override
    public Iterable<DepartmentsAndPostsOfWorker> getDepartmentsAndPostsOfWorkerByDepartmentId(@PathVariable Long id){


        return  departmentsAndPostsOfWorkerRepository.getDepartmentsAndPostsOfWorkerByDepartmentId(id);
    }

    @Override
    public Optional<DepartmentsAndPostsOfWorker> getDepartmentsAndPostsOfWorkerById(@PathVariable Long id){


        return  departmentsAndPostsOfWorkerRepository.findById(id);
    }

    @Override
    public void deleteDepartmentsAndPostsOfWorker(Long id){
        departmentsAndPostsOfWorkerRepository.deleteById(id);
    }
}
