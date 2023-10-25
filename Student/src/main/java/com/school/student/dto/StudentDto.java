package com.school.student.dto;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class StudentDto {
    private Long id;
    private String firstName;
    private String lastName;
    private int roll_no;
    private int subjectCode;
}
