package com.example.test.app.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Column;

@Entity
public class DepartmentHeader {
    
    @Id
    @Column(name = "department_id", nullable = false)
    private String departmentId;

    @Column(name = "employee_id", nullable = false, unique = true)
    private String employeeId;

    @OneToMany
    @JoinColumn(name = "department_id")
    private DepartmentDetail department;

}
