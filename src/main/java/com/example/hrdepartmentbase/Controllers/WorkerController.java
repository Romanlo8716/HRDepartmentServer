package com.example.hrdepartmentbase.Controllers;

import com.example.hrdepartmentbase.Models.ViewModels.DescriptionWorker;
import com.example.hrdepartmentbase.Models.Worker;
import com.example.hrdepartmentbase.Repository.WorkerRepository;
import com.example.hrdepartmentbase.Services.WorkerService;
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
    private WorkerRepository workerRepository;

    @Autowired
    public WorkerController(WorkerRepository workerRepository) {
        this.workerRepository = workerRepository;
    }
    ObjectMapper objectMapper = new ObjectMapper();


    @PostMapping(value = "createWorkers")
 public void post(@RequestBody Worker worker){

        workerRepository.save(worker);
        logger.info("All records saved.");
 }


    @GetMapping(value = "getWorkers")
 public Iterable<Worker> get(){

       Iterable<Worker> workers = new ArrayList<>();
       workers = workerRepository.findAll();
       return  workers;
 }

 @GetMapping(value = "/getWorkerById/{id}")
    public Optional<Worker> getById(@PathVariable("id") Long id){
        Optional<Worker> workers = null;

        workers = workerRepository.findById(id);

     return workers;
 }



 @GetMapping(value = "/findByName/{name}")
 public List<Worker> getByName(@PathVariable("name") String name){
        List<Worker> workers = workerRepository.findAllByName(name);
        return  workers;
 }




 @PutMapping(value = "putWorker/{id}")
    public Worker putWorker(@PathVariable("id") Long id, @RequestBody Worker worker){

        Worker workerUpdate = workerRepository.findById(id).orElseThrow(() -> new ExpressionException("Worker not exist with id: " + id));

        workerUpdate.setName(worker.getName());

        return workerRepository.save(worker);
 }

 @DeleteMapping(value = "deleteWorker/{id}")
    public void deleteWorker(@PathVariable ("id") Long id, @RequestBody Worker worker){
       workerRepository.deleteById(id);
 }

}
