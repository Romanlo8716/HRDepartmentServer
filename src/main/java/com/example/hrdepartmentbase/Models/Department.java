package com.example.hrdepartmentbase.Models;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.*;
import jakarta.validation.constraints.Pattern;
import lombok.Data;
import org.hibernate.engine.internal.Cascade;

import java.util.List;

@Data
@Entity
public class Department {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

 @Column(length = 50, nullable = false)
 @Pattern(regexp = "^[А-ЯЁ]{1}[а-яёА-Яё ]+", message = "Название отдела должно быть с заглавной буквы!")
    private String nameDepartment;

 @Column(length = 15, nullable = false)
 @Pattern(regexp = "^((8|\\+7)[\\- ]?)?(\\(?\\d{3}\\)?[\\- ]?)?[\\d\\- ]{7,10}$", message = "Некорректный номер телефона!")
    private String phoneNumber;


    @ManyToOne
    //@JoinColumn
    private AdressOfDepartment adressOfDepartment;

//    @OneToMany(mappedBy = "department",cascade = CascadeType.ALL)
//    private List<DepartmentsAndPostsOfWorker> departmentsAndPostsOfWorkers;






}
