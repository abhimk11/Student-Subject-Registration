package com.school.subject.controller;

import com.school.subject.dto.SubjectDto;
import com.school.subject.entity.Subject;
import com.school.subject.service.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("subject")
public class SubjectController {

    @Autowired
    SubjectService subjectService;

    @GetMapping("{subjectCode}")
    public ResponseEntity<SubjectDto> getSubject(@PathVariable("subjectCode") int subjectCode){
        return new ResponseEntity<>(subjectService.getSubject(subjectCode), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<SubjectDto> createSubject(@RequestBody Subject subject){
        return new ResponseEntity<>(subjectService.createSubject(subject),HttpStatus.CREATED);
    }

}
