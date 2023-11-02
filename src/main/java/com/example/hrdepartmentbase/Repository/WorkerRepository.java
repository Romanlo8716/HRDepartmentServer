package com.example.hrdepartmentbase.Repository;

import com.example.hrdepartmentbase.Models.Worker;
import jakarta.transaction.Transactional;
import jdk.dynalink.linker.LinkerServices;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface WorkerRepository extends CrudRepository<Worker, Long> {

  List<Worker> findAllByName(String Name);

  @Transactional
  @Modifying
  @Query("delete from DepartmentsAndPostsOfWorker d1_0 where d1_0.worker.id=:id")
  void deleteDepartmentsAndPostsOfWorkerByWorkerId(@Param("id") Long id);


}
