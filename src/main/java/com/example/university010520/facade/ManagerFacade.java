package com.example.university010520.facade;

import com.example.university010520.Exception.CourseDoesNotExist;
import com.example.university010520.Exception.CourseNameAlreadyTakenExceptioln;
import com.example.university010520.Exception.StudentDoesNotExist;
import com.example.university010520.beans.Course;
import com.example.university010520.beans.Student;
import com.example.university010520.db.CourseRepository;
import com.example.university010520.db.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ManagerFacade {

    private CourseRepository courseRepo;
    private StudentRepository studentRepo;

    public ManagerFacade(CourseRepository courseRepo, StudentRepository studentRepo) {
        this.courseRepo = courseRepo;
        this.studentRepo = studentRepo;
    }

    public void addStudent(Student student) throws CourseDoesNotExist {
        courseRepo.findById(student.getCourse().getId()).orElseThrow(CourseDoesNotExist::new);
        studentRepo.save(student);
    }

    public void addCourse(Course course) throws CourseNameAlreadyTakenExceptioln {
        Course c = courseRepo.findByName(course.getName());
        if(c instanceof Course)
            throw new CourseNameAlreadyTakenExceptioln();
        else
            courseRepo.save(course);
    }

    public void deleteStudent(int studentId) throws StudentDoesNotExist {
        studentRepo.findById(studentId).orElseThrow(StudentDoesNotExist::new);
        studentRepo.deleteById(studentId);
    }

    public void deleteCourse(int courseId) throws CourseDoesNotExist {
        courseRepo.findById(courseId).orElseThrow(CourseDoesNotExist::new);
        courseRepo.deleteById(courseId);
    }

    public List<Student> getAllStudent(){
        return studentRepo.findAll();
    }

    public List<Course> getAllCourse(){
        return courseRepo.findAll();
    }

    public Student getStudentById(int studentId) throws StudentDoesNotExist {
        return studentRepo.findById(studentId).orElseThrow(StudentDoesNotExist::new);
    }

    public Course getCourseById(int courseId) throws CourseDoesNotExist {
        return courseRepo.findById(courseId).orElseThrow(CourseDoesNotExist::new);
    }

    public Course getCourseByName(String courseName) throws CourseDoesNotExist {
        Course c = courseRepo.findByName(courseName);
        if(c instanceof Course)
            return c;
        else
            throw new CourseDoesNotExist();
    }

    public List<Student> getAllTalentStudent(){
        ArrayList<Student> talentStudent = new ArrayList<Student>();
        for ( Student student:studentRepo.findAll() ){
            if(student.getGrade() >= 90)
                talentStudent.add(student);
        }
        return talentStudent;
    }

    public String getCourseNameByStudentId(int studentId) throws StudentDoesNotExist {
        return studentRepo.findById(studentId).orElseThrow(StudentDoesNotExist::new).getCourse().getName();
    }
}
