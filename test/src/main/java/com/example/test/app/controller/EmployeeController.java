package com.example.test.app.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.test.app.entity.Employee;
import com.example.test.app.service.EmployeeService;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;


    @PostMapping("/create")
    public ResponseEntity<Employee> createEmployee(@RequestBody Employee employee) {
        Employee savedEmployee = employeeService.createEmployee(employee);
        return ResponseEntity.ok(savedEmployee);
    }

    //find department by id
    @GetMapping("/employees/{departmentId}")
    public ResponseEntity<List<Employee>> findEmployeesByDepartmentId(@PathVariable("departmentId") String departmentId) {
    List<Employee> employees = employeeService.findEmployeesByDepartmentId(departmentId);
    return ResponseEntity.ok(employees);
    }

    //find employee by id
    @GetMapping("/employees/{employeeId}")
    public ResponseEntity<List<Employee>> findEmployeesByEmployeeId(@PathVariable("employeeId") String employeeId) {
    List<Employee> employees = employeeService.findEmployeesByHeadEmployeeId(employeeId);
    List<Employee> employeeLast = new ArrayList<>();

    //check employeeId in department 
    if (employees == null || employees.isEmpty()) {
         employeeLast =  employeeService.findEmployeesByEmployeeId(employeeId);
    } else {
        employeeLast =  employeeService.findEmployeesByHeadTeamEmployeeId(employeeId);
    }
    return ResponseEntity.ok(employeeLast);
    }
}
