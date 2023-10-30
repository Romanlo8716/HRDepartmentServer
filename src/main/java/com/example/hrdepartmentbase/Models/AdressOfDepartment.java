package com.example.hrdepartmentbase.Models;


//import jakarta.persistence.*;
import jakarta.persistence.*;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
@Entity
public class AdressOfDepartment {

   @Id
   @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(length = 50, nullable = false)
    @Pattern(regexp = "^[А-ЯЁ]{1}[а-яёА-ЯЁ ]+", message = "Некорректное название города!")
    private String city;

    @Column(length = 50, nullable = false)
    @Pattern(regexp = "^[А-ЯЁ]{1}[а-яёА-ЯЁ ]+", message = "Некорректное название улицы!")
    private String street;

    @Column(length = 10, nullable = false)
    @Pattern(regexp = "^[0-9]{1}[0-9а-я/]+|^[0-9]{1}", message = "Некорректное номер дома!")
    private String house;


}
