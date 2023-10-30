package com.example.hrdepartmentbase.Controllers;

import com.example.hrdepartmentbase.Models.*;
import com.example.hrdepartmentbase.Models.ViewModels.DescriptionWorker;
import com.example.hrdepartmentbase.Repository.DescriptionWorkerRepository;
import com.example.hrdepartmentbase.Repository.WorkerRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*")
public class DescriptionWorkerController {

    private final static Logger logger = LoggerFactory.getLogger(DescriptionWorkerController.class);
    private DescriptionWorkerRepository descriptionWorkerRepository;

    @Autowired
    public DescriptionWorkerController(DescriptionWorkerRepository descriptionWorkerRepository) {
        this.descriptionWorkerRepository = descriptionWorkerRepository;
    }
    ObjectMapper objectMapper = new ObjectMapper();

    @GetMapping(value = "/getDescriptionWorkerLaborBooks/{id}")
    public Iterable<LaborBook> getDescriptionWorkerLaborBooks(@PathVariable("id") Long id){
        Iterable<LaborBook> descriptionWorker;

        descriptionWorker = descriptionWorkerRepository.getDescriptionWorkerLaborBooks(id);

        return descriptionWorker;
    }

    @GetMapping(value = "/getDescriptionWorkerEducations/{id}")
    public Iterable<Education> getDescriptionWorkerEducations(@PathVariable("id") Long id){
        Iterable<Education> descriptionWorker;

        descriptionWorker = descriptionWorkerRepository.getDescriptionWorkerEducations(id);

        return descriptionWorker;
    }

    @GetMapping(value = "/getDescriptionWorkerVacations/{id}")
    public Iterable<Vacation> getDescriptionWorkerVacations(@PathVariable("id") Long id){
        Iterable<Vacation> descriptionWorker;

        descriptionWorker = descriptionWorkerRepository.getDescriptionWorkerVacations(id);

        return descriptionWorker;
    }

    @GetMapping(value = "/getDescriptionWorkerMedicalBooks/{id}")
    public Iterable<MedicalBook> getDescriptionWorkerMedicalBooks(@PathVariable("id") Long id){
        Iterable<MedicalBook> descriptionWorker;

        descriptionWorker = descriptionWorkerRepository.getDescriptionWorkerMedicalBooks(id);

        return descriptionWorker;
    }

    @GetMapping(value = "/getDescriptionWorkerDepartmentsAndPosts/{id}")
    public Iterable<DepartmentsAndPostsOfWorker> getDescriptionWorkerDepartmentsAmdPosts(@PathVariable("id") Long id){
        Iterable<DepartmentsAndPostsOfWorker> descriptionWorker;

        descriptionWorker = descriptionWorkerRepository.getDescriptionWorkerDepartmentsAndPosts(id);

        return descriptionWorker;
    }

}
