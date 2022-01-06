package org.mma.training.java.spring.service;

import java.util.ArrayList;
import java.util.List;

import org.mma.training.java.spring.model.DoeMetadata;
import org.mma.training.java.spring.repository.DoeMetadataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class DoeMetadataService implements IDoeMetadataService {
	@Autowired
	private DoeMetadataRepository doeMetadataRepository;
	@Override
	public DoeMetadata getDoeMetadataByDoeId(long doeId) {
		DoeMetadata obj = doeMetadataRepository.findById(doeId).get();
		return obj;
	}	
	@Override
	public List<DoeMetadata> getAllDoeMetadata(){
		List<DoeMetadata> list = new ArrayList<>();
		doeMetadataRepository.findAll().forEach(e -> list.add(e));
		return list;
	}
	
	@Override
	public synchronized boolean addDoeMetadata(DoeMetadata doeMetadata){

		DoeMetadata u = getDoeMetadataByDoeId(doeMetadata.getDoeId());
		
       if (u != null) {
    	   return false;
       } else {
    	   doeMetadataRepository.save(doeMetadata);
    	   return true;
       }
	}
	@Override
	public void updateDoeMetadata(DoeMetadata doeMetadata) {
		doeMetadataRepository.save(doeMetadata);
	}
	@Override
	public void deleteDoeMetadata(int doeId) {
		doeMetadataRepository.delete(getDoeMetadataByDoeId(doeId));
	}
}
