package com.example.university010520.Exception;

public class StudentDoesNotExist extends Exception{
    public StudentDoesNotExist() {
        super("student does not exist");
    }
}
