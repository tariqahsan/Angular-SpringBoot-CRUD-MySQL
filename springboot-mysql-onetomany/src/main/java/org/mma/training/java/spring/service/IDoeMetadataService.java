package org.mma.training.java.spring.service;

import java.util.List;

import org.mma.training.java.spring.model.DoeMetadata;

public interface IDoeMetadataService {
     List<DoeMetadata> getAllDoeMetadata();
     DoeMetadata getDoeMetadataByDoeId(long doeId);
     boolean addDoeMetadata(DoeMetadata doeMetadata);
     void updateDoeMetadata(DoeMetadata doeMetadata);
     void deleteDoeMetadata(int doeId);
}
