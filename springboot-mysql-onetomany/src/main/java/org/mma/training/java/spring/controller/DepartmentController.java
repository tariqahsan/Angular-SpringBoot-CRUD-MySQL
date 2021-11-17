package org.mma.training.java.spring.controller;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Optional;

import javax.validation.Valid;

import org.mma.training.java.spring.exception.ResourceNotFoundException;
import org.mma.training.java.spring.model.Department;
import org.mma.training.java.spring.model.Employee;
import org.mma.training.java.spring.repository.DepartmentRepository;
import org.mma.training.java.spring.service.DepartmentService;
import org.mma.training.java.spring.util.ErrorMessage;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
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
public class DepartmentController {

	@Autowired
	DepartmentRepository departmentRepository;
	
	@Autowired
	MessageSource messageSource;

	@Autowired
	DepartmentService departmentService;

	@GetMapping("/departments")
	public ResponseEntity<List<Department>> getAllDepartments() {
		List<Department> departments = new ArrayList<>();
		try {
			departmentRepository.findAll().forEach(departments::add);
			if(departments.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(departments, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/departments/{id}")
	public ResponseEntity<Department> getDepartmentsById(@PathVariable("id") Long id) {
		Optional<Department> departmentsData = departmentRepository.findById(id);

		if (departmentsData.isPresent()) {
			return new ResponseEntity<>(departmentsData.get(), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@PostMapping(value = "/department/add")
	public ResponseEntity postDepartment(@RequestBody @Valid final Department department, BindingResult bindingResult) {

		try {

			List<String> errorList = new ArrayList<>();
			List<ErrorMessage> errorMessages = new ArrayList<>();
			if (bindingResult.hasErrors()) {
				bindingResult.getFieldErrors().forEach(fieldError ->
				errorList.add(fieldError.getField() + ": " + messageSource.getMessage(fieldError, Locale.US))
						);
				bindingResult
				.getFieldErrors()
				.stream()
				.forEach(fieldError -> {            
					ErrorMessage errorMessage = new ErrorMessage(messageSource.getMessage(fieldError, Locale.US), fieldError.getField());           	
					System.out.println(errorMessage.getMessage());
					System.out.println(errorMessage.getFieldName());
					errorMessages.add(errorMessage);
				});
				return new ResponseEntity<>(errorMessages, HttpStatus.NOT_ACCEPTABLE);
		
			}

			Department departmentData = departmentRepository.save(department);
			return new ResponseEntity<>(departmentData, HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.EXPECTATION_FAILED);
		}
	}

	@DeleteMapping("/department/delete/{id}")
	public ResponseEntity<HttpStatus> deleteDepartment(@PathVariable("id") Long id) {
		System.out.println("Deleting id -> " + id);
		try {
			departmentRepository.deleteById(id);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
		}
	}

	@DeleteMapping("/department/delete-all")
	public ResponseEntity<HttpStatus> deleteAllDepartments() {
		System.out.println("Deleting all departments");
		try {
			departmentRepository.deleteAll();
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
		}
	}

	@PutMapping("/department/update/{id}")
	public ResponseEntity<Department> updateDepartment(@PathVariable(value = "id") Long departmentId, @RequestBody Department departmentObj) {
		Optional<Department> department = departmentRepository.findById(departmentId);
		System.out.println(department.get().getName());
		//      @Valid @RequestBody Department employeeDetails) throws ResourceNotFoundException {
		//Department department = departmentRepository.findById(departmentId)
		//     .orElseThrow(() -> new ResourceNotFoundException("Department not found for this id :: " + departmentId));
		//Department departmentObj = new Department();
		//System.out.println(department.get());
		BeanUtils.copyProperties(department.get(), departmentObj);
		for (Employee e : departmentObj.getEmployees()) {
			System.out.println(e.getId() + " " + e.getFullName() + " " + e.getManagerName());
		}
		final Department updatedDepartment = departmentRepository.save(departmentObj);
		return ResponseEntity.ok(updatedDepartment);
		//return ResponseEntity.ok(departmentDetails);
	}
	
	@PutMapping("/department/update")
	public ResponseEntity<Department> updateDepartmentEmployee(@RequestBody Department departmentDetails) {
		
		// @Valid @RequestBody Department employeeDetails) throws ResourceNotFoundException {
		// Department department = departmentRepository.findById(departmentId)
		// .orElseThrow(() -> new ResourceNotFoundException("Department not found for this id :: " + departmentId));
		
		// Create a Department object
		Department departmentObj = new Department();

		BeanUtils.copyProperties(departmentDetails, departmentObj);
		System.out.println(departmentObj.getId());
		Optional<Department> department = departmentRepository.findById(departmentObj.getId());
		System.out.println(department.get().getId());
		BeanUtils.copyProperties(departmentDetails, department);
		for(Employee e : department.get().getEmployees()) {
			System.out.println(e.getManagerName());
		}
		final Department updatedDepartment = departmentRepository.save(departmentObj);
		return ResponseEntity.ok(updatedDepartment);
	}
	

}
