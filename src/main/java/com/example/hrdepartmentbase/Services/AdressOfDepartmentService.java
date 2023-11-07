package com.example.hrdepartmentbase.Services;

import com.example.hrdepartmentbase.Models.AdressOfDepartment;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Optional;

public interface AdressOfDepartmentService {

    Iterable<AdressOfDepartment> getAllAdressOfDepartments();

    Optional<AdressOfDepartment> getAdressOfDepartmentById(@PathVariable Long id);

    void createAdressOfDepartments(@RequestBody AdressOfDepartment adressOfDepartment);

    void deleteAdressOfDepartment(@PathVariable Long id);

    void updateAdressOfDepartment(@PathVariable Long id, @RequestBody AdressOfDepartment adressOfDepartment);


}
