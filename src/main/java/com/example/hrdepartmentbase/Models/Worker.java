package com.example.hrdepartmentbase.Models;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.util.Date;
import java.util.List;

@Data
@Entity
@Table(name = "worker")
public class Worker {

   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;


    @Column(length = 20,nullable = false)
    @Pattern(regexp = "^[А-ЯЁ]{1}[а-яё]+$", message = "Некорректное имя!")
    private String name;

 @Column(length = 30,nullable = false)
 @Pattern(regexp = "^[А-ЯЁ]{1}[а-яё]+$", message = "Некорректная фамилия!")
    private String surname;

 @Column(length = 30,nullable = true)
 @Pattern(regexp = "^[А-ЯЁ]{1}[а-яё]+$", message = "Некорректное отчество!")
    private String patronymic;

 @Column(length = 15,nullable = true)
 @Pattern(regexp = "^((8|\\+7)[\\- ]?)?(\\(?\\d{3}\\)?[\\- ]?)?[\\d\\- ]{7,10}$", message = "Некорректный номер телефона!")
    private String phone;

 @Column(nullable = false)
    private Date dateOfBirth;

 @Column(length = 40,nullable = false)
 @Pattern(regexp = "^[А-ЯЁ]{1}[а-яё]+$", message = "Некорректный населенный пункт!")
    private String city;

 @Column(length = 40,nullable = false)
 @Pattern(regexp = "^[А-ЯЁ]{1}[а-яё]+$", message = "Некорректная улица!")
    private String street;

 @Column(length = 40, nullable = false)
 @Pattern(regexp = "^[0-9/а-я]+$", message = "Некорректный номер дома!")
    private String house;

 @Column(length = 10, nullable = false)
    private String familyPosition;

 @Column(nullable = false)
    private int countChildren;

 @Column(length = 20, nullable = true)
 @Email(message = "Неверный емайл адрес!")
    private String email;

 @Column(length = 4, nullable = false)
 @Pattern(regexp = "^([0-9]{4})?$", message = "Некорректая серия паспорта!")
    private String seriesPass;

 @Column(length = 6, nullable = false)
 @Pattern(regexp = "[0-9]{6}", message = "Некорректный номер паспорта!")
    private String numberPass;

 @Column(nullable = false)
 @Pattern(regexp = "^[А-ЯЁ]{1}[А-ЯЁа-яё ]+$", message = "Некорректное поле!")
    private String issuedByWhom;

 @Column(nullable = false)
    private Date dateOfIssue;

 @Column(length = 7, nullable = false)
 @Pattern(regexp = "^[0-9]{3}[-]{1}[0-9]{3}$", message = "Некорректный код подразделения!")
    private String divisionCode;

 @Column(nullable = false)
 @Pattern(regexp = "(\\d{3}-\\d{3}-\\d{3}[ ]{1}\\d{2}$)|(^\\d{3}-\\d{3}-\\d{3}-\\d{2}$)", message = "Некорректный номер снилс!")
    private String numberSnils;

 @Column(nullable = false)
 @Pattern(regexp = "^[0-9]{12}?$", message = "Некорректный номер ИНН!")
    private String numberInn;

 @Column(length = 10, nullable = false)
    private String gender;


 @Column(length = 20)
    private String militaryTitle;

 @Column(length = 5)
    private String shelfLife;

 @Column(length = 10)
    private int stockCategory;

 @Column(length = 30)
 @Pattern(regexp = "^[А-ЯЁ]{1}[а-яё ]+$", message = "Некорректный состав!")
    private String profile;

 @Column(length = 50)
    private String vus;


    private String nameKomis;

    public String photo;

    public String descriptionWorker;

    private boolean dismiss;

   @ManyToMany(cascade = CascadeType.ALL)
  private List<Department> departments;

   @ManyToMany(cascade = CascadeType.ALL)
 private List<Post> posts;

}
