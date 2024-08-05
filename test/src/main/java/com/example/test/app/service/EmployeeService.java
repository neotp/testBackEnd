package com.example.test.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.test.app.entity.Employee;
import com.example.test.app.repository.EmployeeRepository;

import java.util.List;

@Service
public class EmployeeService {

  
    @Autowired
    private EmployeeRepository employeeRepository;

    public Employee createEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }
  
    public List<Employee> findEmployeesByDepartmentId(String departmentId) {
        return employeeRepository.findEmployeesByDepartmentId(departmentId);
    }
    
    public List<Employee> findEmployeesByHeadEmployeeId(String employeeId) {
        return employeeRepository.findEmployeesByHeadEmployeeId(employeeId);
    }

    public List<Employee> findEmployeesByEmployeeId(String employeeId) {
        return employeeRepository.findEmployeesByEmployeeId(employeeId);
    }
    public List<Employee> findEmployeesByHeadTeamEmployeeId(String employeeId) {
        return employeeRepository.findEmployeesByHeadTeamEmployeeId(employeeId);
    }
    

}