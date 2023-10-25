package com.notificationservice;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentPlacedEvent {
    private String firstName;
    private String lastName;
    private int roll_no;
}
