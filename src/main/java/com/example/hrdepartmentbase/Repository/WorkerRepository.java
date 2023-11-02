package com.example.hrdepartmentbase.Repository;

import com.example.hrdepartmentbase.Models.Worker;
import jdk.dynalink.linker.LinkerServices;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface WorkerRepository extends CrudRepository<Worker, Long> {

  List<Worker> findAllByName(String Name);




}
