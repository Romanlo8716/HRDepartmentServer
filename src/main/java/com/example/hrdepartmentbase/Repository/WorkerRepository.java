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

  @Transactional
  @Modifying
  @Query("delete from Education e1_0 where e1_0.worker.id=:id")
  void deleteEducationWorker(@Param("id") Long id);

  @Transactional
  @Modifying
  @Query("delete from MedicalBook m1_0 where m1_0.worker.id=:id")
  void deleteMedicalBookWorker(@Param("id") Long id);

  @Transactional
  @Modifying
  @Query("delete from Vacation v1_0 where v1_0.worker.id=:id")
  void deleteVacationWorker(@Param("id") Long id);

  @Transactional
  @Modifying
  @Query("delete from LaborBook l1_0 where l1_0.worker.id=:id")
  void deleteLaborBookWorker(@Param("id") Long id);

  @Query("select w1_0 from Worker w1_0 where w1_0.dismiss=true")
  Iterable<Worker> getDissmised();
}
