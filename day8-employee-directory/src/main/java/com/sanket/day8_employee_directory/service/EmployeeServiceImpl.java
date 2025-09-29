package com.sanket.day8_employee_directory.service;

import com.sanket.day8_employee_directory.dto.EmployeeRequest;
import com.sanket.day8_employee_directory.dto.EmployeeResponse;
import com.sanket.day8_employee_directory.entity.Employee;
import com.sanket.day8_employee_directory.exception.ResourceNotFoundException;
import com.sanket.day8_employee_directory.repository.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EmployeeServiceImpl implements EmployeeService{

    private final EmployeeRepository repository;

    @Override
    public EmployeeResponse createEmployee(EmployeeRequest request){
        Employee employee = Employee.builder()
                .firstName(request.getFirstName())
                .lastName(request.getLastName())
                .email(request.getEmail())
                .department(request.getDepartment())
                .position(request.getPosition())
                .salary(request.getSalary())
                .build();
        repository.save(employee);
        return toResponse(employee);
    }

    @Override
    public EmployeeResponse getEmployee(Long id){
        Employee emp = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Employee not found"));
        return toResponse(emp);
    }

    @Override
    public EmployeeResponse updateEmployee(Long id, EmployeeRequest request){
        Employee emp = repository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("Employee not found"));
        emp.setFirstName(request.getFirstName());
        emp.setLastName(request.getLastName());
        emp.setEmail(request.getEmail());
        emp.setDepartment(request.getDepartment());
        emp.setPosition(request.getPosition());
        emp.setSalary(request.getSalary());
        repository.save(emp);
        return toResponse(emp);
    }


    @Override
    public void deleteEmployee(Long id) {
        repository.deleteById(id);
    }

    @Override
    public Page<EmployeeResponse> listEmployees(String nameFilter, int page, int size, String sortBy, String direction) {
        Sort sort = direction.equalsIgnoreCase("desc")
                ? Sort.by(sortBy).descending()
                : Sort.by(sortBy).ascending();
        Pageable pageable  = PageRequest.of(page, size, sort);
        Page<Employee> pageEmployees;
        if(nameFilter != null && !nameFilter.isEmpty()){
            pageEmployees = repository.findByFirstNameContainingIgnoreCase(nameFilter, pageable);
        }
        else {
            pageEmployees = repository.findAll(pageable);
        }
        return pageEmployees.map(this::toResponse);
    }


    private EmployeeResponse toResponse(Employee employee) {
        return EmployeeResponse.builder()
                .id(employee.getId())
                .fullName(employee.getFirstName() + " " + employee.getLastName())
                .email(employee.getEmail())
                .department(employee.getDepartment())
                .position(employee.getPosition())
                .salary(employee.getSalary())
                .build();
    }

}
