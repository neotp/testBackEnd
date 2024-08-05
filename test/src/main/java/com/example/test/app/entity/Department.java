package com.example.test.app.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Column;

@Entity
public class Department {

    @Id
    @Column(name = "department_id", nullable = false, unique = true)
    private String departmentId;

    @Column(name = "department_name", nullable = false)
    private String departmentName;

    @Column(name = "org_code", nullable = false)
    private String orgCode;


    @OneToMany
    @JoinColumn(name = "department_id")
    private DepartmentDetail department;
}
