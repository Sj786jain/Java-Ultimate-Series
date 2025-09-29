package com.sanket.day8_employee_directory.service;

import com.sanket.day8_employee_directory.dto.EmployeeRequest;
import com.sanket.day8_employee_directory.dto.EmployeeResponse;
import org.springframework.data.domain.Page;

public interface EmployeeService {

    EmployeeResponse createEmployee(EmployeeRequest request);
    EmployeeResponse getEmployee(Long id);
    EmployeeResponse updateEmployee(Long id, EmployeeRequest request);
    void deleteEmployee(Long id);
    Page<EmployeeResponse> listEmployees(String nameFilter, int page, int size, String sortBy, String direction);

}
