package com.example.hrdepartmentbase.Services;

import com.example.hrdepartmentbase.Controllers.WorkerController;
import com.example.hrdepartmentbase.Models.Department;
import com.example.hrdepartmentbase.Models.Post;
import com.example.hrdepartmentbase.Repository.DepartmentRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.expression.ExpressionException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class DepartmentServiceImpl implements DepartmentService{
    private final static Logger logger = LoggerFactory.getLogger(WorkerController.class);
    private DepartmentRepository departmentRepository;

    public DepartmentServiceImpl(DepartmentRepository departmentRepository) {
        this.departmentRepository = departmentRepository;
    }

    @Override
    public Iterable<Department> getAllDepartments() {
        Iterable<Department> departments = new ArrayList<>();
        departments = departmentRepository.findAll();
        return  departments;
    }

    @Override
    public Optional<Department> getDepartmentsById(Long id) {

        Optional<Department> department = departmentRepository.findById(id);
        return  department;
    }

    @Override
    public void createDepartments(Department department) {
        departmentRepository.save(department);
        logger.info("All records saved.");
    }

    @Override
    public void deleteDepartment(Long id) {
        departmentRepository.deleteDepartmentsAndPostsOfWorkersByDepartment_Id(id);
        departmentRepository.deleteById(id);
        logger.info("Department delete.");
    }

    @Override
    public void updateDepartment(Long id, Department department) {
        Department departmentUpdate = departmentRepository.findById(id).orElseThrow(() -> new ExpressionException("Post not exist with id: " + id));

        departmentUpdate.setNameDepartment(department.getNameDepartment());
        departmentUpdate.setPhoneNumber(department.getPhoneNumber());
        departmentUpdate.setAdressOfDepartment(department.getAdressOfDepartment());

        departmentRepository.save(departmentUpdate);
    }
}
