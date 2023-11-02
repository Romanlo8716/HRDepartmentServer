package com.example.hrdepartmentbase.Repository;

import com.example.hrdepartmentbase.Models.AdressOfDepartment;
import com.example.hrdepartmentbase.Models.Department;
import com.example.hrdepartmentbase.Models.DepartmentsAndPostsOfWorker;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface DepartmentRepository  extends CrudRepository<Department, Long>
  {

    //List<Department> findByAdress(AdressOfDepartment adressOfDepartment);

    @Transactional
    @Modifying
    @Query("delete from DepartmentsAndPostsOfWorker d1_0 where d1_0.department.id=:id")
    void deleteDepartmentsAndPostsOfWorkersByDepartment_Id(@Param("id") Long id);

}
