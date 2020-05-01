package com.example.university010520.db;

import com.example.university010520.beans.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepository extends JpaRepository<Course,Integer> {
    Course findByName(String courseName);
}
