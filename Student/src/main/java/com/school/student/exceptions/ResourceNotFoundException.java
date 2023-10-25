package com.school.student.exceptions;

public class ResourceNotFoundException extends Exception {
    public ResourceNotFoundException(String s) {
        super(s);
    }

    public ResourceNotFoundException(){
        super("Resource not found on server!!!");
    }
}
