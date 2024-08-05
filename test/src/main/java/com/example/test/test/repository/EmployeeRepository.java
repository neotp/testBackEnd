package com.example.test.test.repository;

import com.example.test.test.entity.Employee;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, String> {


    @Query("SELECT e.employeeId , e.employeeName, e.mobileNo, e.startDate, d.departmentName,dh.employeeId"+
            "FROM Employee e "+
            "JOIN e.Department d"+
            "JOIN DepartmentHeader dh "+
            "ON d.departmentId = dh.departmentid "+
            "WHERE dh.departmentId = :departmentId "+
            "AND (terminateDate IS NULL OR terminateDate = '00000000')")
    List<Employee> findEmployeesByDepartmentId(@Param("departmentId") String departmentId);
    
    @Query("SELECT e "+
           "FROM DepartmentHeader dh"+
           "JOIN DepartmentDetail dd ON dh.departmentId = dd.departmentId "+
           "WHERE dh.employeeId = :employeeId")
    List<Employee> findEmployeesByHeadEmployeeId(@Param("employeeId") String employeeId);

    @Query("SELECT e.employeeId ,e.employeeName ,e.mobileNo"+
           "FROM Employee e"+
           "JOIN DepartmentDetail dd ON e.employeeId = dd.employeeId "+
           "JOIN DepartmentHeader dh ON dd.departmentId = dh.departmentId "+
           "WHERE dh.employeeId = :employeeId")
    List<Employee> findEmployeesByEmployeeId(@Param("employeeId") String employeeId);

    @Query("SELECT e.employeeId ,e.employeeName ,e.mobileNo , e.startDate, d.departmentName"+
           "FROM Employee e"+
           "JOIN e.Department d"+
           "JOIN DepartmentDetail dd ON e.employeeId = dd.employeeId "+
           "JOIN DepartmentHeader dh ON dd.departmentId = dh.departmentId "+
           "WHERE dh.employeeId = :employeeId")
    List<Employee> findEmployeesByHeadTeamEmployeeId(@Param("employeeId") String employeeId);

}
