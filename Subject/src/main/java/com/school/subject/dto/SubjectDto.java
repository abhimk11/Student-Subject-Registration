package com.school.subject.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class SubjectDto {
    private Long id;
    private String subjectName;
    private String description;
    private int subjectCode;
}
