package com.school.student.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class APIResponseDto {

    private StudentDto studentDto;
    private SubjectDto subjectDto;
}
