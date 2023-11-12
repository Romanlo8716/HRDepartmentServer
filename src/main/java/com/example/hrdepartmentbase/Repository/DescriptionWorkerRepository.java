package com.example.hrdepartmentbase.Repository;

import com.example.hrdepartmentbase.Models.*;
import com.example.hrdepartmentbase.Models.ViewModels.DescriptionWorker;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface DescriptionWorkerRepository extends CrudRepository<DescriptionWorker, Long> {
//    @Query("Select jsonb_build_object('laborBooks', jsonb_agg(jsonb_build_object('id', l1_0.id, 'dateRecord', l1_0.dateRecord, 'informationAboutWork',l1_0.informationAboutWork,'nameDocument',l1_0.nameDocument, 'nameWork',l1_0.nameWork, 'numberDocument' ,l1_0.numberDocument)), " +
//            "'vacations', jsonb_agg(jsonb_build_object('id', v1_0.id, 'dateEndVacation', v1_0.dateEndVacation, 'dateStartVacation' ,v1_0.dateStartVacation, 'footing', v1_0.footing, 'typeVacation' ,v1_0.typeVacation))," +
//            "'educations', jsonb_agg(jsonb_build_object('id', e1_0.id, 'dateYearEnd', e1_0.dateYearEnd, 'numberDiploma', e1_0.numberDiploma, 'seriesDiploma', e1_0.seriesDiploma, 'special', e1_0.special))," +
//            "'medicalBooks', jsonb_agg(jsonb_build_object('id', m1_0.id, 'conclusion', m1_0.conclusion, 'dateExam' ,m1_0.dateExam, 'placeExam' ,m1_0.placeExam))) from Worker w1_0 join LaborBook l1_0 on  w1_0.id=l1_0.worker.id join Education e1_0 on w1_0.id=e1_0.worker.id join Vacation v1_0 on w1_0.id=v1_0.worker.id join MedicalBook m1_0 on w1_0.id=m1_0.worker.id")
    // @Query("Select jsonb_build_object('laborBooks', jsonb_agg(jsonb_build_object('id', l1_0.id, 'dateRecord', l1_0.dateRecord, 'informationAboutWork',l1_0.informationAboutWork,'nameDocument',l1_0.nameDocument, 'nameWork',l1_0.nameWork, 'numberDocument' ,l1_0.numberDocument))) from Worker w1_0 join LaborBook l1_0 on  w1_0.id=l1_0.worker.id")
    @Query("Select l1_0 from LaborBook l1_0 join Worker w1_0 on l1_0.worker.id=w1_0.id where w1_0.id=:id order by l1_0.dateRecord desc ")
    Iterable<LaborBook> getDescriptionWorkerLaborBooks(@Param("id") Long id);

    //@Query("Select jsonb_build_object('educations', jsonb_agg(jsonb_build_object('id', e1_0.id, 'seriesDiploma', e1_0.seriesDiploma, 'numberDiploma',e1_0.numberDiploma,'dateYearEnd',e1_0.dateYearEnd, 'special',e1_0.special))) from Worker w1_0 join Education e1_0 on  w1_0.id=e1_0.worker.id")
    @Query("Select e1_0 from Education e1_0 join Worker w1_0 on e1_0.worker.id=w1_0.id where w1_0.id=:id order by e1_0.dateYearEnd desc")
    Iterable<Education> getDescriptionWorkerEducations(@Param("id") Long id);

    @Query("Select v1_0 from Vacation v1_0 join Worker w1_0 on v1_0.worker.id=w1_0.id where w1_0.id=:id order by v1_0.dateStartVacation desc")
    Iterable<Vacation> getDescriptionWorkerVacations(@Param("id") Long id);

    @Query("Select m1_0 from MedicalBook m1_0 join Worker w1_0 on m1_0.worker.id=w1_0.id where w1_0.id=:id order by m1_0.dateExam desc")
    Iterable<MedicalBook> getDescriptionWorkerMedicalBooks(@Param("id") Long id);

    @Query("Select d1_0 from DepartmentsAndPostsOfWorker d1_0 join Worker w1_0 on d1_0.worker.id=w1_0.id where w1_0.id=:id ")
    Iterable<DepartmentsAndPostsOfWorker> getDescriptionWorkerDepartmentsAndPosts(@Param("id") Long id);


}
