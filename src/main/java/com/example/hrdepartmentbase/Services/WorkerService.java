package com.example.hrdepartmentbase.Services;

import com.example.hrdepartmentbase.Models.Worker;

import java.util.List;

public interface WorkerService {

    void create(Worker worker);

    List<Worker> readAll();

    Worker readById(int id);

    boolean update(Worker worker, int id);

    boolean delete(int id);
}
