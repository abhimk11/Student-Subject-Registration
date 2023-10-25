package com.school.student.service;

import com.school.student.dto.APIResponseDto;
import com.school.student.dto.StudentDto;
import com.school.student.entity.Student;
import com.school.student.exceptions.ResourceNotFoundException;

public interface StudentService {
    public StudentDto GetStudent(Long id) throws ResourceNotFoundException;
    public StudentDto createStudent(Student student);

    public APIResponseDto getStudentById(Long StudentId) throws ResourceNotFoundException;
}
