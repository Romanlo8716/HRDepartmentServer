package com.example.hrdepartmentbase.Services;

import com.example.hrdepartmentbase.Controllers.WorkerController;
import com.example.hrdepartmentbase.Models.AdressOfDepartment;
import com.example.hrdepartmentbase.Repository.AdressOfDepartmentRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.expression.ExpressionException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class AdressOfDepartmentServiceImpl implements AdressOfDepartmentService{

    private final static Logger logger = LoggerFactory.getLogger(WorkerController.class);
    private AdressOfDepartmentRepository adressOfDepartmentRepository;

    public AdressOfDepartmentServiceImpl(AdressOfDepartmentRepository adressOfDepartmentRepository) {
        this.adressOfDepartmentRepository = adressOfDepartmentRepository;
    }

    @Override
    public Iterable<AdressOfDepartment> getAllAdressOfDepartments() {
        Iterable<AdressOfDepartment> adressOfDepartments = new ArrayList<>();
        adressOfDepartments = adressOfDepartmentRepository.findAll();
        return  adressOfDepartments;
    }

    @Override
    public Optional<AdressOfDepartment> getAdressOfDepartmentById(Long id) {
        Optional<AdressOfDepartment> adressOfDepartment = adressOfDepartmentRepository.findById(id);
        return  adressOfDepartment;
    }

    @Override
    public void createAdressOfDepartments(AdressOfDepartment adressOfDepartment) {
        adressOfDepartmentRepository.save(adressOfDepartment);
        logger.info("All records saved.");
    }

    @Override
    public void deleteAdressOfDepartment(Long id) {
        adressOfDepartmentRepository.deleteDepartmentsByAdressOfDepartment_Id(id);
        adressOfDepartmentRepository.deleteById(id);
        logger.info("Department delete.");
    }

    @Override
    public  void updateAdressOfDepartment(Long id,AdressOfDepartment adressOfDepartment){
        AdressOfDepartment updateAdressOfDepartment = adressOfDepartmentRepository.findById(id).orElseThrow(() -> new ExpressionException("Worker not exist with id: " + id));
        updateAdressOfDepartment.setCity(adressOfDepartment.getCity());
        updateAdressOfDepartment.setStreet(adressOfDepartment.getStreet());
        updateAdressOfDepartment.setHouse(adressOfDepartment.getHouse());
        adressOfDepartmentRepository.save(updateAdressOfDepartment);
    }
}
