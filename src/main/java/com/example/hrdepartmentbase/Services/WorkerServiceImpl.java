package com.example.hrdepartmentbase.Services;

import com.example.hrdepartmentbase.Models.DepartmentsAndPostsOfWorker;
import com.example.hrdepartmentbase.Models.Worker;
import com.example.hrdepartmentbase.Repository.DepartmentsAndPostsOfWorkerRepository;
import com.example.hrdepartmentbase.Repository.WorkerRepository;
import org.springframework.expression.ExpressionException;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class WorkerServiceImpl implements WorkerService {

    private WorkerRepository workerRepository;
    private DepartmentsAndPostsOfWorkerRepository departmentsAndPostsOfWorkerRepository;

    public WorkerServiceImpl(WorkerRepository workerRepository, DepartmentsAndPostsOfWorkerRepository departmentsAndPostsOfWorkerRepository) {
        this.workerRepository = workerRepository;
        this.departmentsAndPostsOfWorkerRepository = departmentsAndPostsOfWorkerRepository;
    }

    @Override
    public List<Worker> getCandidates() {

        List<Worker> candidates = new ArrayList<>();
        boolean flag = false;
        for(Worker worker : workerRepository.findAll()){
            flag = false;
            for (DepartmentsAndPostsOfWorker departmentsAndPostsOfWorker : departmentsAndPostsOfWorkerRepository.findAll()){
                if(worker.getId()==departmentsAndPostsOfWorker.getWorker().getId()){
                    flag = true;
                    break;
                }

            }
            if(flag==false && worker.isDismiss()==false){
                candidates.add(worker);
            }
        }

        return candidates;
    }

    @Override
    public List<Worker> getWorkersOnCompany() {

        List<Worker> workers = new ArrayList<>();
        boolean flag = false;
        for(Worker worker : workerRepository.findAll()){
            flag = false;
            for (DepartmentsAndPostsOfWorker departmentsAndPostsOfWorker : departmentsAndPostsOfWorkerRepository.findAll()){
                if(worker.getId()==departmentsAndPostsOfWorker.getWorker().getId()){
                    flag = true;
                    break;
                }

            }
            if(flag==true && worker.isDismiss()==false){
                workers.add(worker);
            }
        }

        return workers;
    }

    @Override
    public Iterable<Worker> getDissmised(){
        return workerRepository.getDissmised();
    }

    @Override
    public void createWorker(Worker worker) {
          workerRepository.save(worker);
    }

    @Override
    public Iterable<Worker> getWorker() {
        Iterable<Worker> workers = workerRepository.findAll();

        return workers;
    }

    @Override
    public Optional<Worker> getWorkerById(Long id) {

        Optional<Worker> worker = workerRepository.findById(id);

        return worker;
    }

    @Override
    public List<Worker> getByName(String name) {

        List<Worker> workers = workerRepository.findAllByName(name);

        return workers;
    }

    @Override
    public Worker putWorker(Long id, Worker worker) {

        Worker workerUpdate = workerRepository.findById(id).orElseThrow(() -> new ExpressionException("Worker not exist with id: " + id));

        workerUpdate.setName(worker.getName());

        return workerRepository.save(worker);
    }

    @Override
    public void deleteWorker(Long id) {
          workerRepository.deleteDepartmentsAndPostsOfWorkerByWorkerId(id);
          workerRepository.deleteEducationWorker(id);
          workerRepository.deleteVacationWorker(id);
          workerRepository.deleteLaborBookWorker(id);
          workerRepository.deleteMedicalBookWorker(id);
          workerRepository.deleteById(id);
    }

    @Override
    public  void dismissWorker(Long id){
        Worker worker = workerRepository.findById(id).orElseThrow(() -> new ExpressionException("Worker not exist with id: " + id));

        worker.setDismiss(true);
        workerRepository.deleteDepartmentsAndPostsOfWorkerByWorkerId(id);
        workerRepository.save(worker);
    }

    @Override
    public  void recoveryWorker(Long id){
        Worker worker = workerRepository.findById(id).orElseThrow(() -> new ExpressionException("Worker not exist with id: " + id));

        worker.setDismiss(false);

        workerRepository.save(worker);
    }
}
