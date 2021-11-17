package org.mma.training.java.spring.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.mma.training.java.spring.model.PinRequest;
import org.mma.training.java.spring.repository.PinRequestRepository;
import org.mma.training.java.spring.service.PinRequestService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
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
public class PinRequestController {
	
	@Autowired
	PinRequestRepository pinRequestRepository;
	
	@Autowired
	PinRequestService pinRequestService;
	
	@GetMapping("/pinRequests")
	public ResponseEntity<List<PinRequest>> getAllPinRequests() {
		List<PinRequest> pinRequests = new ArrayList<>();
		try {
			pinRequestRepository.findAll().forEach(pinRequests::add);
			if(pinRequests.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(pinRequests, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/pinRequests/{id}")
	public ResponseEntity<PinRequest> getPinRequestsById(@PathVariable("id") long id) {
		Optional<PinRequest> pinRequestsData = pinRequestRepository.findById(id);

		if (pinRequestsData.isPresent()) {
			return new ResponseEntity<>(pinRequestsData.get(), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
    
    @PostMapping(value = "/pinRequests/add")
	public ResponseEntity<PinRequest> postPinRequest(@RequestBody PinRequest pinRequest) {
    	
		try {
			PinRequest pinRequestData = pinRequestRepository.save(pinRequest);
			return new ResponseEntity<>(pinRequestData, HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.EXPECTATION_FAILED);
		}
	}
    
    @DeleteMapping("/pinRequests/delete/{id}")
	public ResponseEntity<HttpStatus> deletePinRequest(@PathVariable("id") long id) {
    	System.out.println("Deleting id -> " + id);
		try {
			pinRequestRepository.deleteById(id);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
		}
	}
    
    @DeleteMapping("/pinRequests/delete-all")
	public ResponseEntity<HttpStatus> deleteAllPinRequests() {
    	System.out.println("Deleting all pinRequests");
		try {
			pinRequestRepository.deleteAll();
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
		}
	}
    
    // Updates article
//  	@PutMapping(value= "/update", produces= { MediaType.APPLICATION_XML_VALUE })
    @PutMapping(value= "/pinRequests/update")
  	public ResponseEntity<PinRequest> updatePinRequest(@RequestBody PinRequest pinRequest) {
  		System.out.println("PinRequest Division Cage Code : " + pinRequest.getDivisionCageCode());
  		System.out.println("pinRequest.getId() : " + pinRequest.getId());
  		PinRequest pinRequestObj = new PinRequest();
  		BeanUtils.copyProperties(pinRequest, pinRequestObj);
  		//pinRequestObj.setPinRequestId(1L);
//  		System.out.println("pinRequestObj.getPinRequestId() : " + pinRequestObj.getPinRequestId());
//  		System.out.println("pinRequestObj.getAddress().getZip4() : " + pinRequestObj.getAddress().getZip4());
  		pinRequestService.updatePinRequest(pinRequestObj);
  		
  		PinRequest ob = new PinRequest();
  		BeanUtils.copyProperties(pinRequestObj, ob);
  		return new ResponseEntity<PinRequest>(ob, HttpStatus.OK);
  	}
  	
  //Updates article
//  	@PutMapping(value= "article", produces= { MediaType.APPLICATION_XML_VALUE })
//  	public ResponseEntity<ArticleInfo> updateArticle(@RequestBody ArticleInfo articleInfo) {
//  		Article article = new Article();
//  		BeanUtils.copyProperties(articleInfo, article);		
//  		articleService.updateArticle(article);
//  		
//  		ArticleInfo ob = new ArticleInfo();
//  		BeanUtils.copyProperties(article, ob);
//  		return new ResponseEntity<ArticleInfo>(ob, HttpStatus.OK);
//  	}
    @PutMapping("/pinRequests/update/{id}")
    public ResponseEntity<PinRequest> updatePinRequest(@PathVariable(value = "id") Long pinRequestId, @RequestBody PinRequest pinRequestDetails) {
    	Optional<PinRequest> pinRequest = pinRequestRepository.findById(pinRequestId);
    	System.out.println(pinRequest.get().getDivisionCageCode());
    	System.out.println(pinRequest.get().getDivisionName());
//      @Valid @RequestBody PinRequest employeeDetails) throws ResourceNotFoundException {
    	//PinRequest pinRequest = pinRequestRepository.findById(pinRequestId)
//     .orElseThrow(() -> new ResourceNotFoundException("PinRequest not found for this id :: " + pinRequestId));
 		//PinRequest pinRequestObj = new PinRequest();
    	pinRequestDetails.setId(pinRequest.get().getId());
//  		BeanUtils.copyProperties(pinRequest, pinRequestObj);
    	BeanUtils.copyProperties(pinRequest.get(), pinRequestDetails);
    	
//  		System.out.println(pinRequestObj.getAddress().getZip4());
    	System.out.println("pinRequest.get().getId() --> " + pinRequest.get().getId());
    	System.out.println("pinRequestDetails.getDivisionCageCode() --> " + pinRequestDetails.getDivisionCageCode());
    	System.out.println("pinRequestDetails.getPoc().getFirstName() --> " + pinRequestDetails.getPoc().getFirstName());
    	System.out.println("pinRequestDetails.getPoc().getLastName() --> " + pinRequestDetails.getPoc().getLastName());
    	System.out.println("pinRequestDetails.getPoc().getPhone() --> " + pinRequestDetails.getPoc().getPhone());
    	System.out.println("pinRequestDetails.getPoc().getEmail() --> " + pinRequestDetails.getPoc().getEmail());
//     final PinRequest updatedPinRequest = pinRequestRepository.save(pinRequestObj);
    	// Set ID 
    	pinRequestDetails.setId(pinRequest.get().getId());
    	System.out.println("pinRequestDetails.getId() --> " + pinRequestDetails.getId());
    	final PinRequest updatedPinRequest = pinRequestRepository.save(pinRequestDetails);
     return ResponseEntity.ok(updatedPinRequest);
    }

}
