package com.example.university010520.beans;

import com.example.university010520.Exception.durationMustBeBetween40And500Exception;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "courses")
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column
    private String name;
    @Column
    private int duration;
    @JsonManagedReference
    @OneToMany(mappedBy = "course",fetch = FetchType.EAGER,cascade = CascadeType.REMOVE)
    private List<Student> students;

    public Course() {
    }
    public Course(String name, int duration) throws durationMustBeBetween40And500Exception {
        this.name = name;
        if(duration <= 500 && duration >=40)
            this.duration = duration;
        else
            throw new durationMustBeBetween40And500Exception();
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

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

}
