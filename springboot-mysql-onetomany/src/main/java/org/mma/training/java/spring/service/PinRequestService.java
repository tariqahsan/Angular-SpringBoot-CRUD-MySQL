package org.mma.training.java.spring.service;

import java.util.ArrayList;
import java.util.List;

import org.mma.training.java.spring.model.PinRequest;
import org.mma.training.java.spring.repository.PinRequestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class PinRequestService implements IPinRequestService {
	@Autowired
	private PinRequestRepository pinRequestRepository;
	@Override
	public PinRequest getPinRequestById(long pinRequestId) {
		PinRequest obj = pinRequestRepository.findById(pinRequestId).get();
		return obj;
	}	
	@Override
	public List<PinRequest> getAllPinRequests(){
		List<PinRequest> list = new ArrayList<>();
		pinRequestRepository.findAll().forEach(e -> list.add(e));
		return list;
	}
	
	@Override
	public synchronized boolean addPinRequest(PinRequest pinRequest){

		PinRequest u = getPinRequestById(pinRequest.getId());
		
       if (u != null) {
    	   return false;
       } else {
    	   pinRequestRepository.save(pinRequest);
    	   return true;
       }
	}
	@Override
	public void updatePinRequest(PinRequest pinRequest) {
		pinRequestRepository.save(pinRequest);
	}
	@Override
	public void deletePinRequest(int pinRequestId) {
		pinRequestRepository.delete(getPinRequestById(pinRequestId));
	}
}
