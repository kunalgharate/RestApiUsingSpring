package com.justproject.demo.entities;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.Period;

@Entity
@Table
public class Student {

    @Id
    @SequenceGenerator(name = "student_sequence",sequenceName = "student_sequence",allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "student_sequence")
    private long id;
    private String name;
    @Transient
    private int age;
    private LocalDate dov;
    private String email;

    public Student() {
    }

    public Student(long id, String name, LocalDate dov, String email) {
        this.id = id;
        this.name = name;
        this.dov = dov;
        this.email = email;
    }

    public Student(String name, LocalDate dov, String email) {
        this.name = name;
        this.dov = dov;
        this.email = email;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setDov(LocalDate dov) {
        this.dov = dov;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return Period.between(this.dov,LocalDate.now()).getYears();
    }

    public LocalDate getDov() {
        return dov;
    }

    public String getEmail() {
        return email;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", dov=" + dov +
                ", email='" + email + '\'' +
                '}';
    }
}
