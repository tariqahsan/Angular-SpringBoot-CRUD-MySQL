package org.mma.training.java.spring.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.mma.training.java.spring.model.Employee;
import org.mma.training.java.spring.repository.EmployeeRepository;
import org.mma.training.java.spring.service.EmployeeService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "*")
//@CrossOrigin(origins = "http://localhost:3737")
@RestController
@RequestMapping("/api/v1")
public class EmployeeController {
	
	@Autowired
	EmployeeRepository employeeRepository;
	
	@Autowired
	EmployeeService employeeService;
	
	@GetMapping("/employee")
	public ResponseEntity<List<Employee>> getAllEmployees() {
		List<Employee> employees = new ArrayList<>();
		try {
			employeeRepository.findAll().forEach(employees::add);
			if(employees.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(employees, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/employee/{id}")
	public ResponseEntity<Employee> getEmployeesById(@PathVariable("id") long id) {
		Optional<Employee> employeesData = employeeRepository.findById(id);

		if (employeesData.isPresent()) {
			return new ResponseEntity<>(employeesData.get(), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
    
    @PostMapping(value = "/employee/add")
	public ResponseEntity<Employee> postEmployee(@RequestBody Employee employee) {
    	System.out.println(employee.getFullName());
		try {
			Employee employeeData = employeeRepository.save(employee);
			return new ResponseEntity<>(employeeData, HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.EXPECTATION_FAILED);
		}
	}
    
    @DeleteMapping("/employee/delete/{id}")
	public ResponseEntity<HttpStatus> deleteEmployee(@PathVariable("id") long id) {
    	System.out.println("Deleting id -> " + id);
		try {
			employeeRepository.deleteById(id);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
		}
	}
    
    @DeleteMapping("/employee/delete-all")
	public ResponseEntity<HttpStatus> deleteAllEmployees() {
    	System.out.println("Deleting all employees");
		try {
			employeeRepository.deleteAll();
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
		}
	}
    
    // Updates article
    // @PutMapping(value= "/update", produces= { MediaType.APPLICATION_XML_VALUE })
    @PutMapping(value= "/employee/update")
  	public ResponseEntity<Employee> updateEmployee(@RequestBody Employee employee) {
  		System.out.println("Employee FullName : " + employee.getFullName());
  		System.out.println("employee.getId() : " + employee.getId());
  		Employee emp = employeeRepository.getOne(employee.getId());
  		System.out.println("emp.getDepartment().getId(): " + emp.getDepartment().getId());
  		Employee employeeObj = new Employee();
  		
  		BeanUtils.copyProperties(employee, employeeObj);
  		employeeObj.setDepartment(emp.getDepartment());
  		employeeService.updateEmployee(employeeObj);
  		
  		Employee ob = new Employee();
  		BeanUtils.copyProperties(employeeObj, ob);
  		return new ResponseEntity<Employee>(ob, HttpStatus.OK);
  	}
  	

    @PutMapping("/employee/update/{id}")
    public ResponseEntity<Employee> updateEmployee(@PathVariable(value = "id") Long employeeId, @RequestBody Employee employeeDetails) {
    	Optional<Employee> employee = employeeRepository.findById(employeeId);
    	System.out.println(employee.get().getFullName());
    	System.out.println(employee.get().getId());
//      @Valid @RequestBody Employee employeeDetails) throws ResourceNotFoundException {
    	//Employee employee = employeeRepository.findById(employeeId)
//     .orElseThrow(() -> new ResourceNotFoundException("Employee not found for this id :: " + employeeId));

    	employeeDetails.setId(employee.get().getId());

    	BeanUtils.copyProperties(employee.get(), employeeDetails);
    	
    	System.out.println("employee.get().getId() --> " + employee.get().getId());
    	System.out.println("employeeDetails.getId() --> " + employeeDetails.getId());
    	
    	System.out.println("employeeDetails.getFullName() --> " + employeeDetails.getFullName());
    	
    	// Set ID 
    	employeeDetails.setId(employee.get().getId());
    	System.out.println("employeeDetails.getId() --> " + employeeDetails.getId());
    	final Employee updatedEmployee = employeeRepository.save(employeeDetails);
     return ResponseEntity.ok(updatedEmployee);
    }

}
