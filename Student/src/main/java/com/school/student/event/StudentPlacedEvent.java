package com.school.student.event;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentPlacedEvent {
    private String firstName;
    private String lastName;
    private int roll_no;
}
