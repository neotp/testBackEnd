package com.example.test.test.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Column;

@Entity
public class DepartmentDetail {

    @Id
    @Column(name = "employee_id", nullable = false, unique = true)
    private String employeeId;

    @Column(name = "department_id", nullable = false)
    private String departmentId;

    @OneToMany
    @JoinColumn(name = "employee_id")
    private DepartmentHeader employees;

}
