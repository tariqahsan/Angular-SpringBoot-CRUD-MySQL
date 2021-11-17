package org.mma.training.java.spring.repository;

import org.mma.training.java.spring.model.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Long>{

}
