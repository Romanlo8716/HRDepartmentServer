package com.example.hrdepartmentbase.Models;


import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

import java.util.List;

@Data
@Entity
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false)
    @Min(value = 15000, message = "Значение зарплаты не может быть меньше 15000 рублей!")
    private double salary;

    @Column(length = 100, nullable = false)
    @Pattern(regexp = "^[А-ЯЁ]{1}[а-яё ]+", message = "Название должности должно быть с заглавной буквы!")
    private String namePost;


}
