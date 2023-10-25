package com.school.student.mapper;

import com.school.student.dto.StudentDto;
import com.school.student.entity.Student;

public class StudentMapper {

    public static StudentDto StudentToStudentDto(Student student){

        StudentDto studentDto = new StudentDto(
                student.getId(),
                student.getFirstName(),
                student.getLastName(),
                student.getRoll_no(),
                student.getSubjectCode());
        return studentDto;
    }

    public Student StudentDtoToStudent(StudentDto studentDto){

        Student student = new Student(
                studentDto.getId(),
                studentDto.getFirstName(),
                studentDto.getLastName(),
                studentDto.getRoll_no(),
                studentDto.getSubjectCode());
        return student;
    }

}
