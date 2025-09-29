package com.sanket.day8_employee_directory.controller;

import com.sanket.day8_employee_directory.dto.EmployeeRequest;
import com.sanket.day8_employee_directory.dto.EmployeeResponse;
import com.sanket.day8_employee_directory.service.EmployeeService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/employees")
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
public class EmployeeController {

    private final EmployeeService service;

    @PostMapping
    public EmployeeResponse create(@Valid @RequestBody EmployeeRequest request){
        return service.createEmployee(request);
    }

    @GetMapping("/{id}")
    public EmployeeResponse get(@PathVariable Long id){
        return service.getEmployee(id);
    }

    @PutMapping("/{id}")
    public EmployeeResponse update(@PathVariable Long id, @Valid @RequestBody EmployeeRequest request){
        return service.updateEmployee(id, request);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
        service.deleteEmployee(id);
    }

    @GetMapping
    public Page<EmployeeResponse> list(
        @RequestParam(defaultValue =  "")String name,
        @RequestParam(defaultValue = "0") int page,
        @RequestParam(defaultValue = "5") int size,
        @RequestParam(defaultValue = "id") String sortBy,
        @RequestParam(defaultValue = "asc") String direction
    ) {
        return service.listEmployees(name, page, size, sortBy, direction);
    }



}
