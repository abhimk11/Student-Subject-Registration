package com.school.subject.service.impl;

import com.school.subject.dto.SubjectDto;
import com.school.subject.entity.Subject;
import com.school.subject.mapper.SubjectMapper;
import com.school.subject.repository.SubjectRepository;
import com.school.subject.service.SubjectService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class SubjectServiceImpl implements SubjectService {

    @Autowired
    private SubjectRepository subjectRepository;

    @Override
    public SubjectDto getSubject(int subjectCode){
        Subject subject =  subjectRepository.findBySubjectCode(subjectCode);
        SubjectDto subjectDto = SubjectMapper.SubjectToSubjectDto(subject);
        return subjectDto;
    }

    @Override
    public SubjectDto createSubject(Subject subject) {
        Subject savedSubject = subjectRepository.save(subject);
        SubjectDto subjectDto = SubjectMapper.SubjectToSubjectDto(savedSubject);
        return subjectDto;
    }

}
