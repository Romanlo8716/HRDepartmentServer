package com.example.hrdepartmentbase.Controllers;

import com.example.hrdepartmentbase.Models.DepartmentsAndPostsOfWorker;
import com.example.hrdepartmentbase.Models.Worker;
import com.example.hrdepartmentbase.Repository.WorkerRepository;
import com.example.hrdepartmentbase.Services.WorkerService;
import com.example.hrdepartmentbase.Services.WorkerServiceImpl;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.expression.ExpressionException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.ResourceUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@CrossOrigin(origins = "*")
public class WorkerController {

    private final static Logger logger = LoggerFactory.getLogger(WorkerController.class);
    private WorkerServiceImpl workerService;

    @Autowired
    public WorkerController(WorkerServiceImpl workerService) {
        this.workerService = workerService;
    }



    @PostMapping(value = "createWorkers")
 public void post(@RequestBody Worker worker){

        workerService.createWorker(worker);
        logger.info("All records saved.");
 }


    @GetMapping(value = "getWorkers")
 public Iterable<Worker> get(){


       return workerService.getWorker();
 }

 @GetMapping(value = "/getWorkerById/{id}")
    public Optional<Worker> getById(@PathVariable("id") Long id){

     return workerService.getWorkerById(id);
 }



 @GetMapping(value = "/findByName/{name}")
 public List<Worker> getByName(@PathVariable("name") String name){

        return workerService.getByName(name);
 }

 @GetMapping(value = "/getCandidates")
 public List<Worker> getCandidates(){
        return workerService.getCandidates();
 }

    @GetMapping(value = "/getWorkersOnCompany")
    public List<Worker> getWorkersOnCompany(){
        return workerService.getWorkersOnCompany();
    }

    @GetMapping(value = "/getDissmised")
    public Iterable<Worker> getDissmised(){
        return workerService.getDissmised();
    }

 @PutMapping(value = "putWorker/{id}")
    public Worker putWorker(@PathVariable("id") Long id, @RequestBody Worker worker){



        return workerService.putWorker(id, worker);
 }

 @DeleteMapping(value = "deleteWorker/{id}")
    public void deleteWorker(@PathVariable ("id") Long id){
        workerService.deleteWorker(id);
 }



@PutMapping(value = "dismissWorker/{id}")
public void dismissWorker(@PathVariable ("id") Long id){
    workerService.dismissWorker(id);
}

    @PutMapping(value = "recoveryWorker/{id}")
    public void recoveryWorker(@PathVariable ("id") Long id){
        workerService.recoveryWorker(id);
    }

}
