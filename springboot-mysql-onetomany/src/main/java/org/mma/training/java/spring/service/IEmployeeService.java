package org.mma.training.java.spring.service;

import java.util.List;

import org.mma.training.java.spring.model.Employee;

public interface IEmployeeService {
     List<Employee> getAllEmployees();
     Employee getEmployeeById(long employeeId);
     boolean addEmployee(Employee employee);
     void updateEmployee(Employee employee);
     void deleteEmployee(long employeeId);
}
