package com.example.university010520.Exception;

public class CourseDoesNotExist extends Exception{
    public CourseDoesNotExist() {
        super("course does not exist");
    }
}
