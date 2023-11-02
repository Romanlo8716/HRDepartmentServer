package com.example.hrdepartmentbase.Repository;

import com.example.hrdepartmentbase.Models.Post;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface PostRepository extends CrudRepository<Post, Long> {

    @Transactional
    @Modifying
    @Query("delete from DepartmentsAndPostsOfWorker d1_0 where d1_0.post.id=:id")
    void deleteDepartmentsAndPostsOfWorkersByPost_Id(@Param("id") Long id);
}
