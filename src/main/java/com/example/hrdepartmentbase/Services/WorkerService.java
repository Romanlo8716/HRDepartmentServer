package com.example.hrdepartmentbase.Services;

import com.example.hrdepartmentbase.Models.Worker;

import java.util.List;
import java.util.Optional;

public interface WorkerService {

   List<Worker> getCandidates();

   List<Worker> getWorkersOnCompany();

   Iterable<Worker> getDissmised();

   void createWorker(Worker worker);

   Iterable<Worker> getWorker();

   Optional<Worker> getWorkerById(Long id);

   List<Worker> getByName(String name);

   Worker putWorker(Long id, Worker worker);

   void deleteWorker(Long id);

   void dismissWorker(Long id);

   void recoveryWorker(Long id);

   void updateWorker(Long id, Worker worker);
}
