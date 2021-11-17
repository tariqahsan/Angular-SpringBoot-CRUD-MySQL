package org.mma.training.java.spring.service;

import java.util.ArrayList;
import java.util.List;

import org.mma.training.java.spring.model.Department;
import org.mma.training.java.spring.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class DepartmentService implements IDepartmentService {
	@Autowired
	private DepartmentRepository departmentRepository;
	@Override
	public Department getDepartmentById(Long departmentId) {
		Department obj = departmentRepository.findById(departmentId).get();
		return obj;
	}	
	@Override
	public List<Department> getAllDepartments(){
		List<Department> list = new ArrayList<>();
		departmentRepository.findAll().forEach(e -> list.add(e));
		return list;
	}
	
	@Override
	public synchronized boolean addDepartment(Department department){

		Department u = getDepartmentById(department.getId());
		
       if (u != null) {
    	   return false;
       } else {
    	   departmentRepository.save(department);
    	   return true;
       }
	}
	@Override
	public void updateDepartment(Department department) {
		departmentRepository.save(department);
	}
	@Override
	public void deleteDepartment(Long departmentId) {
		departmentRepository.delete(getDepartmentById(departmentId));
	}
}
