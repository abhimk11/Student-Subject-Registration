package com.school.student.dto;


import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Builder
@Getter
public class SubjectDto {
    private Long id;
    private String subjectName;
    private String description;
    private int subjectCode;
}
