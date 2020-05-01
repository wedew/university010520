package com.example.university010520;

import com.example.university010520.Exception.*;
import com.example.university010520.beans.Course;
import com.example.university010520.beans.Student;
import com.example.university010520.facade.ManagerFacade;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class University010520Application {

    public static void main(String[] args) {
        ConfigurableApplicationContext ctx =  SpringApplication.run(University010520Application.class, args);

        ManagerFacade managerFacade = ctx.getBean(ManagerFacade.class);

//        try {
//            managerFacade.addCourse(new Course("testcourse", 270));
//        } catch (CourseNameAlreadyTakenExceptioln | durationMustBeBetween40And500Exception e) {
//            System.out.println(e.getMessage());
//        }
//
//        try {
//            managerFacade.addStudent(new Student("teststudent", 13, managerFacade.getCourseByName("Math")));
//        } catch (CourseDoesNotExist | gradeMustBeBetween0And100Exception e) {
//            System.out.println(e.getMessage());
//        }

//        try {
//            managerFacade.deleteCourse(3);
//        } catch (CourseDoesNotExist e) {
//            System.out.println(e.getMessage());;
//        }

//        try {
//            managerFacade.deleteStudent(6);
//        } catch (StudentDoesNotExist e) {
//            System.out.println(e.getMessage());
//        }

//        for ( Student student:managerFacade.getAllStudent() ){
//            System.out.println(student);
//        }

//        for ( Course course:managerFacade.getAllCourse() ){
//            System.out.println(course);
//        }

//        try {
//            System.out.println(managerFacade.getStudentById(2));
//        } catch (StudentDoesNotExist e) {
//            System.out.println(e.getMessage());
//        }

//        for ( Student student:managerFacade.getAllTalentStudent() ){
//            System.out.println(student);
//        }

    }
}
