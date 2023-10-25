package com.school.student.service.impl;

import com.school.student.dto.APIResponseDto;
import com.school.student.dto.StudentDto;
import com.school.student.dto.SubjectDto;
import com.school.student.entity.Student;
import com.school.student.event.StudentPlacedEvent;
import com.school.student.exceptions.ResourceNotFoundException;
import com.school.student.mapper.StudentMapper;
import com.school.student.repository.StudentRepository;
import com.school.student.service.StudentService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

@Service
@AllArgsConstructor
@NoArgsConstructor
public class StudentServiceImpl implements StudentService {

    @Autowired
    private RestTemplate restTemplate;

    /*@Autowired
    private WebClient webClient;*/

    /*@Autowired
    private APIClient apiClient;*/
    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private KafkaTemplate<String, StudentPlacedEvent> kafkaTemplate;

    @Override
    public StudentDto GetStudent(Long id) throws ResourceNotFoundException {

        Student student = studentRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("User with given Id not found on server"));
        StudentDto studentDto = StudentMapper.StudentToStudentDto(student);
        return studentDto;
    }

    @Override
    public StudentDto createStudent(Student student) {
        Student savedStudent = studentRepository.save(student);
        StudentDto studentDto = StudentMapper.StudentToStudentDto(savedStudent);
        return studentDto;
    }

    @Override
    public APIResponseDto getStudentById(Long StudentId) throws ResourceNotFoundException {
        //Exception Handler Global
        Student student = studentRepository.findById(StudentId).orElseThrow(()-> new ResourceNotFoundException("User with given id is not found on server"));
        kafkaTemplate.send("notificationTopic",new StudentPlacedEvent(student.getFirstName(),student.getLastName(),student.getRoll_no()));

        //Using Response Entity
        ResponseEntity<SubjectDto> responseEntity = restTemplate.getForEntity("http://SUBJECT-SERVICE/subject/" + student.getSubjectCode(), SubjectDto.class);
        SubjectDto subjectDto = responseEntity.getBody();

        //Using WebClient
        /*SubjectDto subjectDto = webClient.get().uri("http://localhost:8090/subject/" + student.getSubjectCode())
                .retrieve()
                .bodyToMono(SubjectDto.class)
                .block();*/

        //Using OpenFeign
        //SubjectDto subjectDto = apiClient.getSubject(student.getSubjectCode());

        StudentDto studentDto = StudentMapper.StudentToStudentDto(student);

        APIResponseDto apiResponseDto = new APIResponseDto();
        apiResponseDto.setStudentDto(studentDto);
        apiResponseDto.setSubjectDto(subjectDto);

        return apiResponseDto;
    }
}
