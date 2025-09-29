package com.sanket.day8_employee_directory.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
public class EmployeeResponse {
    private Long id;
    private String fullName;
    private String email;
    private String department;
    private String position;
    private Double salary;

}
