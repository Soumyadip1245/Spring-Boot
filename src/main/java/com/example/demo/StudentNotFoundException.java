package com.example.demo;

public class StudentNotFoundException extends RuntimeException{
    StudentNotFoundException(String message){
        super(message);
    }
}
