package com.school.student.service.impl;

import com.school.student.dto.SubjectDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(url = "http://localhost:8090", value = "SUBJECT-SERVICE")
public interface APIClient {

    @GetMapping("/subject/{subjectCode}")
    SubjectDto getSubject(@PathVariable("subjectCode") int subjectCode);
}

