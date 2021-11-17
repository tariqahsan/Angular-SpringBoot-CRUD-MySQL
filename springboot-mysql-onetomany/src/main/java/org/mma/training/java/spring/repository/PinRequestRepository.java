package org.mma.training.java.spring.repository;

import org.mma.training.java.spring.model.PinRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PinRequestRepository extends JpaRepository<PinRequest, Long>{

}
