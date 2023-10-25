package com.school.subject.service;

import com.school.subject.dto.SubjectDto;
import com.school.subject.entity.Subject;

public interface SubjectService {
    public SubjectDto getSubject(int SubjectCode);

    public SubjectDto createSubject(Subject subject);
}
