package org.mma.training.java.spring.service;

import java.util.List;

import org.mma.training.java.spring.model.PinRequest;

public interface IPinRequestService {
     List<PinRequest> getAllPinRequests();
     PinRequest getPinRequestById(long pinRequestId);
     boolean addPinRequest(PinRequest pinRequest);
     void updatePinRequest(PinRequest pinRequest);
     void deletePinRequest(int pinRequestId);
}
