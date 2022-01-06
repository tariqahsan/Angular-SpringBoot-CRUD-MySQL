package org.mma.training.java.spring.repository;

import org.mma.training.java.spring.model.DoeMetadata;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DoeMetadataRepository extends JpaRepository<DoeMetadata, Long>{

}
