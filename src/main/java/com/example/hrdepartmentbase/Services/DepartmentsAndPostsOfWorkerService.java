package com.example.hrdepartmentbase.Services;

import com.example.hrdepartmentbase.Models.DepartmentsAndPostsOfWorker;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Optional;

public interface DepartmentsAndPostsOfWorkerService {
    public Iterable<DepartmentsAndPostsOfWorker> getGroupByDepartmentsAndPostsOfWorkers();

    public Iterable<DepartmentsAndPostsOfWorker> getAllDepartmentsAndPostsOfWorkers();

    public Iterable<DepartmentsAndPostsOfWorker> getDepartmentsAndPostsOfWorkerByDepartmentId(Long id);

    public Optional<DepartmentsAndPostsOfWorker> getDepartmentsAndPostsOfWorkerById(Long id);

    void deleteDepartmentsAndPostsOfWorker(Long id);
}
