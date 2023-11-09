package com.example.hrdepartmentbase.Services;

import com.example.hrdepartmentbase.Controllers.WorkerController;
import com.example.hrdepartmentbase.Models.Department;
import com.example.hrdepartmentbase.Models.DepartmentsAndPostsOfWorker;
import com.example.hrdepartmentbase.Models.Post;
import com.example.hrdepartmentbase.Models.PostsOfDepartment;
import com.example.hrdepartmentbase.Repository.DepartmentRepository;
import com.example.hrdepartmentbase.Repository.DepartmentsAndPostsOfWorkerRepository;
import com.example.hrdepartmentbase.Repository.PostOfDepartmentRepository;
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
    private PostOfDepartmentRepository postOfDepartmentRepository;

    private DepartmentsAndPostsOfWorkerRepository departmentsAndPostsOfWorkerRepository;

    public DepartmentServiceImpl(DepartmentRepository departmentRepository, PostOfDepartmentRepository postOfDepartmentRepository, DepartmentsAndPostsOfWorkerRepository departmentsAndPostsOfWorkerRepository) {
        this.departmentRepository = departmentRepository;
        this.postOfDepartmentRepository = postOfDepartmentRepository;
        this.departmentsAndPostsOfWorkerRepository = departmentsAndPostsOfWorkerRepository;
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
    public void deletePostOfDepartment(Long id) {

        postOfDepartmentRepository.deleteById(id);
        logger.info("confirm delete.");
    }

    @Override
    public void updateDepartment(Long id, Department department) {
        Department departmentUpdate = departmentRepository.findById(id).orElseThrow(() -> new ExpressionException("Post not exist with id: " + id));

        departmentUpdate.setNameDepartment(department.getNameDepartment());
        departmentUpdate.setPhoneNumber(department.getPhoneNumber());
        departmentUpdate.setAdressOfDepartment(department.getAdressOfDepartment());

        departmentRepository.save(departmentUpdate);
    }

    @Override
    public void updatePostOfDepartment(Long id, PostsOfDepartment postsOfDepartment) {
        PostsOfDepartment postsOfDepartmentUpdate = postOfDepartmentRepository.findById(id).orElseThrow(() -> new ExpressionException("Post not exist with id: " + id));

        postsOfDepartmentUpdate.setCount(postsOfDepartment.getCount());


        postOfDepartmentRepository.save(postsOfDepartmentUpdate);
    }

    @Override
    public void createPostOnDepartment(PostsOfDepartment postsOfDepartment) {
        postOfDepartmentRepository.save(postsOfDepartment);
        logger.info("All records saved.");
    }

    @Override
    public Iterable<PostsOfDepartment>getPostOfDepartment(){
        return postOfDepartmentRepository.findAll();
    }

    @Override
    public Iterable<PostsOfDepartment>getPostOfDepartmentByDepartmentId(Long id){
        return postOfDepartmentRepository.getPostsOfDepartmentsByDepartment_Id(id);
    }

    @Override
    public Optional<PostsOfDepartment> getPostOfDepartmentById(Long id){
        return  postOfDepartmentRepository.findById(id);
    }

    @Override
    public void createAddWorkerOnDepartment(DepartmentsAndPostsOfWorker departmentsAndPostsOfWorker){
        departmentsAndPostsOfWorkerRepository.save(departmentsAndPostsOfWorker);
    }

    @Override
    public Iterable<DepartmentsAndPostsOfWorker> getWorkersOnDepartment(Long id){
       return departmentsAndPostsOfWorkerRepository.getDepartmentsAndPostsOfWorkerByDepartmentId(id);
    }
}
