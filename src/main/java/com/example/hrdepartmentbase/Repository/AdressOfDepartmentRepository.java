package com.example.hrdepartmentbase.Repository;

import com.example.hrdepartmentbase.Models.AdressOfDepartment;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface AdressOfDepartmentRepository extends CrudRepository<AdressOfDepartment, Long> {

    @Transactional
    @Modifying
    @Query("delete from Department d1_0 where d1_0.adressOfDepartment.id=:id")
    void deleteDepartmentsByAdressOfDepartment_Id(@Param("id") Long id);


}
