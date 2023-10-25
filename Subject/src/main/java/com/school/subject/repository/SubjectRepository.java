package com.school.subject.repository;

import com.school.subject.entity.Subject;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SubjectRepository extends JpaRepository<Subject,Long> {
    public Subject findBySubjectCode(int subjectCode);
}
