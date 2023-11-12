package com.example.hrdepartmentbase.Models;


import jakarta.persistence.*;
import jakarta.validation.constraints.Pattern;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.util.List;

@Data
@Entity
public class Education {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(length = 6, nullable = false)
    @Pattern(regexp = "^[0-9]{6}$", message = "Некорректная серия диплома!")
    private String seriesDiploma;

    @Column(length = 7, nullable = false)
    @Pattern(regexp = "^[0-9]{7}$", message = "Некорректный номер диплома!")
    private String numberDiploma;

    @Column(length = 30, nullable = false)
    @Pattern(regexp = "^[А-ЯЁ]{1}[а-яёА-ЯЁ ]+$", message = "Некорректная специальность!")
    private String special;

    @Column(nullable = false)
    private Date dateYearEnd;

    @ManyToOne
   private Worker worker;
}
