package org.mma.training.java.spring.service;

import java.util.ArrayList;
import java.util.List;

import org.mma.training.java.spring.model.Employee;
import org.mma.training.java.spring.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService implements IEmployeeService {
	@Autowired
	private EmployeeRepository employeeRepository;
	
	@Override
	public Employee getEmployeeById(long employeeId) {
		Employee obj = employeeRepository.findById(employeeId).get();
		return obj;
	}	
	@Override
	public List<Employee> getAllEmployees(){
		List<Employee> list = new ArrayList<>();
		employeeRepository.findAll().forEach(e -> list.add(e));
		return list;
	}
	
	@Override
	public synchronized boolean addEmployee(Employee employee){

		Employee u = getEmployeeById(employee.getId());
		
       if (u != null) {
    	   return false;
       } else {
    	   employeeRepository.save(employee);
    	   return true;
       }
	}
	
	@Override
	public void updateEmployee(Employee employee) {
		employeeRepository.save(employee);
		
	}
	@Override
	public void deleteEmployee(long employeeId) {
		// TODO Auto-generated method stub
		
	}
	
}
