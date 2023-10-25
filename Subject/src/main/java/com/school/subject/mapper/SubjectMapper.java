package com.school.subject.mapper;

import com.school.subject.dto.SubjectDto;
import com.school.subject.entity.Subject;

public class SubjectMapper {

    public static SubjectDto SubjectToSubjectDto(Subject subject){

        SubjectDto subjectDto = new SubjectDto(
                subject.getId(),
                subject.getSubjectName(),
                subject.getDescription(),
                subject.getSubjectCode());
        return subjectDto;
    }

    public Subject SubjectDtoToSubject(SubjectDto subjectDto){

        Subject subject = new Subject(
                subjectDto.getId(),
                subjectDto.getSubjectName(),
                subjectDto.getDescription(),
                subjectDto.getSubjectCode());
        return subject;
    }
}
