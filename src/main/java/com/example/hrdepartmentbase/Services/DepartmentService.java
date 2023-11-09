package com.example.hrdepartmentbase.Services;

import com.example.hrdepartmentbase.Models.Department;
import com.example.hrdepartmentbase.Models.DepartmentsAndPostsOfWorker;
import com.example.hrdepartmentbase.Models.PostsOfDepartment;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Optional;

public interface DepartmentService {
    Iterable<Department> getAllDepartments();

    Optional<Department> getDepartmentsById(@PathVariable Long id);

    void createDepartments(@RequestBody Department department);

    void deleteDepartment(@PathVariable Long id);

    void deletePostOfDepartment(Long id);

    void updateDepartment(@PathVariable Long id, @RequestBody Department department);

    void createPostOnDepartment(@RequestBody PostsOfDepartment postsOfDepartment);

    Iterable<PostsOfDepartment> getPostOfDepartment();

    Iterable<PostsOfDepartment> getPostOfDepartmentByDepartmentId(Long id);

    Optional<PostsOfDepartment> getPostOfDepartmentById(Long id);

    void updatePostOfDepartment(Long id, PostsOfDepartment postsOfDepartment);

    void createAddWorkerOnDepartment(DepartmentsAndPostsOfWorker departmentsAndPostsOfWorker);

    Iterable<DepartmentsAndPostsOfWorker> getWorkersOnDepartment(Long id);
}
