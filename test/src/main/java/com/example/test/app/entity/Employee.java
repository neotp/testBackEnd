package com.example.test.app.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.ManyToOne;
import javax.persistence.JoinColumn;
import java.time.LocalDate;

@Entity
public class Employee {

    @Id
    @Column(name = "employee_id", nullable = false, unique = true)
    private String employeeId;

    @Column(name = "employee_name", nullable = false)
    private String employeeName;

    @Column(name = "birthdate", nullable = false)
    private LocalDate birthdate;

    @Column(name = "mobile_no", nullable = false)
    private String mobileNo;

    @Column(name = "email", nullable = false)
    private String email;

    @Column(name = "address", nullable = false)
    private String address;

    @Column(name = "start_date", nullable = false)
    private LocalDate startDate;

    @Column(name = "terminate_date")
    private LocalDate terminateDate;

    @ManyToOne
    @JoinColumn(name = "departmentId")
    private Department department;
}
