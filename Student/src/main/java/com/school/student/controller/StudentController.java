package com.school.student.controller;

import com.school.student.dto.APIResponseDto;
import com.school.student.dto.StudentDto;
import com.school.student.dto.SubjectDto;
import com.school.student.entity.Student;
import com.school.student.exceptions.ResourceNotFoundException;
import com.school.student.service.StudentService;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.ratelimiter.annotation.RateLimiter;
import io.github.resilience4j.retry.annotation.Retry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("student")
public class StudentController {

    private Logger logger = LoggerFactory.getLogger(StudentController.class);
    @Autowired
    private StudentService studentService;

    /*@GetMapping("{id}")
    public ResponseEntity<StudentDto> getStudent(@PathVariable("id")  Long id){
        return new ResponseEntity<>(studentService.GetStudent(id), HttpStatus.OK);
    }*/

    int retryCount=1;
    @GetMapping("{id}")
    //@CircuitBreaker(name = "studentBreaker",fallbackMethod ="studentFallback")
    //@Retry(name = "studentService",fallbackMethod = "studentFallback")
    @RateLimiter(name = "studentRateLimiter",fallbackMethod = "studentFallback")
    public ResponseEntity<APIResponseDto> getStudent(@PathVariable("id")  Long id) throws ResourceNotFoundException {
        logger.info("Retry count: {}",retryCount);
        retryCount++;
        APIResponseDto apiResponseDto = studentService.getStudentById(id);
        return new ResponseEntity<>(apiResponseDto, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<StudentDto> createStudent(@RequestBody Student student){
        return new ResponseEntity<>(studentService.createStudent(student),HttpStatus.CREATED);
    }

    public ResponseEntity<APIResponseDto> studentFallback(Long id,Exception ex) {
        logger.info("Fallback is executed because service is down:", ex.getMessage());
        APIResponseDto apiResponseDto = APIResponseDto.builder().studentDto(
                StudentDto.builder().firstName("Error").lastName("Trial").id(1L).roll_no(1).subjectCode(404).build()
        ).subjectDto(SubjectDto.builder().subjectName("Dummy").description("Error").id(1L).subjectCode(404).build()).build();
        return new ResponseEntity<>(apiResponseDto,HttpStatus.NOT_FOUND);
    }
}
