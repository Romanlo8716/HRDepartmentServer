package com.example.hrdepartmentbase.Repository;

import com.example.hrdepartmentbase.Models.DepartmentsAndPostsOfWorker;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface DepartmentsAndPostsOfWorkerRepository extends CrudRepository<DepartmentsAndPostsOfWorker, Long> {

//    @Query("SELECT e.department, array_to_string(array_agg(concat_ws(',', e.post.id, e.post.namePost, e.post.salary)), '; '), array_to_string(array_agg(e.worker.name), ',') " +
//            "FROM DepartmentsAndPostsOfWorker e  GROUP BY e.department")

   @Query("SELECT jsonb_build_object('department', jsonb_build_object('id', d2_0.id,'nameDepartment', d2_0.nameDepartment, 'phone', d2_0.phoneNumber, 'workers', jsonb_agg(jsonb_build_object('id', w1_0.id, 'name', w1_0.name, 'surname', w1_0.surname, 'phone', w1_0.phone, 'namePost', p1_0.namePost))))  FROM DepartmentsAndPostsOfWorker  d1_0 join Department d2_0 on d2_0.id=d1_0.department.id join Worker  w1_0 on w1_0.id=d1_0.worker.id join Post p1_0 on p1_0.id=d1_0.post.id group by d2_0.id, d2_0.nameDepartment, d2_0.phoneNumber")
    Iterable<DepartmentsAndPostsOfWorker> groupByDepartment();

}
