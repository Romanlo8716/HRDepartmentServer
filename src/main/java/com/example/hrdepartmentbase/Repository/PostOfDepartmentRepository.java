package com.example.hrdepartmentbase.Repository;

import com.example.hrdepartmentbase.Models.PostsOfDepartment;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostOfDepartmentRepository extends CrudRepository<PostsOfDepartment, Long> {

    Iterable<PostsOfDepartment> getPostsOfDepartmentsByDepartment_Id(Long id);
}
