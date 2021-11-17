package org.mma.training.java.spring.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import org.hibernate.annotations.GenericGenerator;

import com.fasterxml.jackson.annotation.JsonManagedReference;


@Entity
@Table(name = "DEPARTMENT")
public class Department {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
	@GenericGenerator(name = "native", strategy = "native")
	@Column(name = "DEPARTMENT_ID", updatable = false, nullable = false)
	private Long id;
	
	@Column(name = "DEPARTMENT_NAME")
	@NotBlank
	@Size(min = 5, max = 20)
	private String name;
	
	@OneToMany(mappedBy = "department", cascade = CascadeType.ALL, orphanRemoval = true)
	@JsonManagedReference
	private List<Employee> employees;
	
	public Department() {}

	public Department(String name, List<Employee> employees) {
		super();
		this.name = name;
		this.employees = employees;
	}

	public Department(Long id, String name, List<Employee> employees) {
		super();
		this.id = id;
		this.name = name;
		this.employees = employees;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Employee> getEmployees() {
		return employees;
	}

	public void setEmployees(List<Employee> employees) {
		this.employees = employees;
	}

	@Override
	public String toString() {
		return "Department [id=" + id + ", name=" + name + ", employees=" + employees + "]";
	}
	
}
