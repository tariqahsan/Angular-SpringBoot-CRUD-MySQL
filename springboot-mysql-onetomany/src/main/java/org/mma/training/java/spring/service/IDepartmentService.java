package org.mma.training.java.spring.service;

import java.util.List;

import org.mma.training.java.spring.model.Department;

public interface IDepartmentService {
     List<Department> getAllDepartments();
     Department getDepartmentById(Long departmentId);
     boolean addDepartment(Department department);
     void updateDepartment(Department department);
     void deleteDepartment(Long departmentId);
}
