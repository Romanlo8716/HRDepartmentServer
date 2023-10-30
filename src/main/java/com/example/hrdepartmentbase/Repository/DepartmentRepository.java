package com.example.hrdepartmentbase.Repository;

import com.example.hrdepartmentbase.Models.AdressOfDepartment;
import com.example.hrdepartmentbase.Models.Department;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface DepartmentRepository  extends CrudRepository<Department, Long>
  {

    //List<Department> findByAdress(AdressOfDepartment adressOfDepartment);


}
