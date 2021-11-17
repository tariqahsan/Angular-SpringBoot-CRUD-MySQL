package org.mma.training.java.spring.repository;

import org.mma.training.java.spring.model.PointOfContact;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PointOfContactRepository extends JpaRepository<PointOfContact, Long>{

}
