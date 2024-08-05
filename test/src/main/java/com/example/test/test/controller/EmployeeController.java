package com.example.test.test.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.test.test.service.EmployeeService;
import com.example.test.test.entity.Employee;

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

    @GetMapping("/employees/{departmentId}")
    public ResponseEntity<List<Employee>> findEmployeesByDepartmentId(@PathVariable("departmentId") String departmentId) {
    List<Employee> employees = employeeService.findEmployeesByDepartmentId(departmentId);
    return ResponseEntity.ok(employees);
    }

    @GetMapping("/employees/{employeeId}")
    public ResponseEntity<List<Employee>> findEmployeesByEmployeeId(@PathVariable("employeeId") String employeeId) {
    List<Employee> employees = employeeService.findEmployeesByHeadEmployeeId(employeeId);
    List<Employee> employeeLast = new ArrayList<>();
    if (employees == null || employees.isEmpty()) {
         employeeLast =  employeeService.findEmployeesByEmployeeId(employeeId);
    } else {
        employeeLast =  employeeService.findEmployeesByHeadTeamEmployeeId(employeeId);
    }
    return ResponseEntity.ok(employeeLast);
    }
}
