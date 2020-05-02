package com.example.university010520.web;

import com.example.university010520.Exception.*;
import com.example.university010520.beans.Course;
import com.example.university010520.beans.Student;
import com.example.university010520.facade.ManagerFacade;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("betsefer")
public class ManagerController {

    private ManagerFacade managerFacade;
    public ManagerController(ManagerFacade managerFacade) {
        this.managerFacade = managerFacade;
    }

    @PostMapping("/addStudent")
    public ResponseEntity<String> addStudent(@RequestBody Student student){
        try {
            Student student1 = new Student(student.getName(),student.getGrade(),student.getCourse());
            managerFacade.addStudent(student1);
            return ResponseEntity.ok("student successfully registered!");
        } catch (gradeMustBeBetween0And100Exception | CourseDoesNotExist e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    @PostMapping("/addCourse")
    public ResponseEntity<String> addCourse(@RequestBody Course course) {
        try {
            Course course1 = new Course(course.getName(), course.getDuration());
            managerFacade.addCourse(course1);
            return ResponseEntity.ok("course successfully registered!");
        } catch (CourseNameAlreadyTakenExceptioln | durationMustBeBetween40And500Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    @DeleteMapping("/deleteStudent")
    public ResponseEntity<String> deleteStudent(@RequestParam int studentId){
        try {
            managerFacade.deleteStudent(studentId);
            return ResponseEntity.ok("student deleted successfully");
        } catch (StudentDoesNotExist e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    @DeleteMapping("/deleteCourse")
    public ResponseEntity<String> deleteCourse(@RequestParam int courseId){
        try {
            managerFacade.deleteCourse(courseId);
            return ResponseEntity.ok("course deleted successfully");
        } catch (CourseDoesNotExist e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }}

    @GetMapping("/getAllStudent")
    public List<Student> getAllStudent(){
        return managerFacade.getAllStudent();
    }

    @GetMapping("/getAllCourse")
    public List<Course> getAllCourse(){
        return managerFacade.getAllCourse();
    }

    @GetMapping("/getOneStudent")
    public ResponseEntity<?> getStudentById(int studentId){
        try {
            return ResponseEntity.ok(managerFacade.getStudentById(studentId));
        } catch (StudentDoesNotExist e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }}

    @GetMapping("/getOneCourse")
    public ResponseEntity<?> getCourseById(int courseId){
        try {
            return ResponseEntity.ok(managerFacade.getCourseById(courseId));
        } catch (CourseDoesNotExist e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }
    @GetMapping("/getOneCourseByName")
    public ResponseEntity<?> getCourseByName(String courseName){
        try {
            return ResponseEntity.ok(managerFacade.getCourseByName(courseName));
        } catch (CourseDoesNotExist e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }
    @GetMapping("/getAllTalentStudents")
    public List<Student> getAllTalentStudent(){
        return managerFacade.getAllTalentStudent();
    }

    @GetMapping("/getCourseNameByStudentId")
    public ResponseEntity<String> getCourseNameByStudentId(@RequestParam int studentId){
        try {
            return ResponseEntity.ok(managerFacade.getCourseNameByStudentId(studentId));
        } catch (StudentDoesNotExist e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }
}
