package com.example.university010520.beans;

import com.example.university010520.Exception.gradeMustBeBetween0And100Exception;
import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;

@Entity
@Table(name = "students")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column
    private String name;
    @Column
    private int grade;
    @JsonBackReference
    @ManyToOne
    private Course course;

    public Student() {

    }
    public Student(String name, int grade, Course course) throws gradeMustBeBetween0And100Exception {
        this.name = name;
        if(grade >= 0 && grade <= 100)
            this.grade = grade;
        else
            throw new gradeMustBeBetween0And100Exception();
        this.course = course;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

}
