package org.example.entity;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
public class Employee {
    private Integer employeeId;
    private String firstName;
    private String lastName;
    private String email;
}
