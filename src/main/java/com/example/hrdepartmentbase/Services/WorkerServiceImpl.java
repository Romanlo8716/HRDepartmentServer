package com.example.hrdepartmentbase.Services;

import com.example.hrdepartmentbase.Models.DepartmentsAndPostsOfWorker;
import com.example.hrdepartmentbase.Models.LaborBook;
import com.example.hrdepartmentbase.Models.Post;
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

    @Override
    public void updateWorker(Long id, Worker worker){
        Worker workerUpdate = workerRepository.findById(id).orElseThrow(() -> new ExpressionException("Post not exist with id: " + id));

        workerUpdate.setName(worker.getName());
        workerUpdate.setSurname(worker.getSurname());
        workerUpdate.setPatronymic(worker.getPatronymic());
        workerUpdate.setDescriptionWorker(worker.getDescriptionWorker());
        workerUpdate.setCity(worker.getCity());
        workerUpdate.setCountChildren(worker.getCountChildren());
        workerUpdate.setDateOfBirth(worker.getDateOfBirth());
        workerUpdate.setDateOfIssue(worker.getDateOfIssue());
        workerUpdate.setDivisionCode(worker.getDivisionCode());
        workerUpdate.setEmail(worker.getEmail());
        workerUpdate.setFamilyPosition(worker.getFamilyPosition());
        workerUpdate.setGender(worker.getGender());
        workerUpdate.setCountChildren(worker.getCountChildren());
        workerUpdate.setHouse(worker.getHouse());
        workerUpdate.setIssuedByWhom(worker.getIssuedByWhom());
        workerUpdate.setMilitaryTitle(worker.getMilitaryTitle());
        workerUpdate.setNameKomis(worker.getNameKomis());
        workerUpdate.setNumberPass(worker.getNumberPass());
        workerUpdate.setNumberSnils(worker.getNumberSnils());
        workerUpdate.setPhone(worker.getPhone());
        workerUpdate.setPhoto(worker.getPhoto());
        workerUpdate.setProfile(worker.getProfile());
        workerUpdate.setSeriesPass(worker.getSeriesPass());
        workerUpdate.setShelfLife(worker.getShelfLife());
        workerUpdate.setStockCategory(worker.getStockCategory());
        workerUpdate.setStreet(worker.getStreet());
        workerUpdate.setVus(worker.getVus());



        workerRepository.save(workerUpdate);
    }

    @Override
    public void addMilitary(Long id, Worker worker) {
        Worker workerUpdate = workerRepository.findById(id).orElseThrow(() -> new ExpressionException("Post not exist with id: " + id));

        workerUpdate.setMilitaryTitle(worker.getMilitaryTitle());
        workerUpdate.setNameKomis(worker.getNameKomis());
        workerUpdate.setProfile(worker.getProfile());
        workerUpdate.setShelfLife(worker.getShelfLife());
        workerUpdate.setStockCategory(worker.getStockCategory());
        workerUpdate.setVus(worker.getVus());

        workerRepository.save(workerUpdate);
    }




}
