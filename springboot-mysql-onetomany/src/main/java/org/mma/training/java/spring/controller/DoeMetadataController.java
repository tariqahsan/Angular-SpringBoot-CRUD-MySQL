package org.mma.training.java.spring.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.mma.training.java.spring.model.DoeMetadata;
import org.mma.training.java.spring.repository.DoeMetadataRepository;
import org.mma.training.java.spring.service.DoeMetadataService;
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
public class DoeMetadataController {
	
	@Autowired
	DoeMetadataRepository doeMetadataRepository;
	
	@Autowired
	DoeMetadataService doeMetadataService;
	
	@GetMapping("/doeMetadata")
	public ResponseEntity<List<DoeMetadata>> getAllDoeMetadatas() {
		List<DoeMetadata> doeMetadata = new ArrayList<>();
		try {
			doeMetadataRepository.findAll().forEach(doeMetadata::add);
			if(doeMetadata.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(doeMetadata, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/doeMetadata/{id}")
	public ResponseEntity<DoeMetadata> getDoeMetadatasById(@PathVariable("id") long id) {
		Optional<DoeMetadata> doeMetadatasData = doeMetadataRepository.findById(id);

		if (doeMetadatasData.isPresent()) {
			return new ResponseEntity<>(doeMetadatasData.get(), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
    
    @PostMapping(value = "/doeMetadata/add")
	public ResponseEntity<DoeMetadata> postDoeMetadata(@RequestBody DoeMetadata doeMetadata) {
    	System.out.println("Posting a new DoeMetadata record ...");
		try {
			DoeMetadata doeMetadataData = doeMetadataRepository.save(doeMetadata);
			return new ResponseEntity<>(doeMetadataData, HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.EXPECTATION_FAILED);
		}
	}
    
    @DeleteMapping("/doeMetadata/delete/{id}")
	public ResponseEntity<HttpStatus> deleteDoeMetadata(@PathVariable("id") long id) {
    	System.out.println("Deleting id -> " + id);
		try {
			doeMetadataRepository.deleteById(id);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
		}
	}
    
    @DeleteMapping("/doeMetadata/delete-all")
	public ResponseEntity<HttpStatus> deleteAllDoeMetadatas() {
    	System.out.println("Deleting all doeMetadata");
		try {
			doeMetadataRepository.deleteAll();
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
		}
	}
    
    // Updates article
//  	@PutMapping(value= "/update", produces= { MediaType.APPLICATION_XML_VALUE })
    @PutMapping(value= "/doeMetadata/update")
  	public ResponseEntity<DoeMetadata> updateDoeMetadata(@RequestBody DoeMetadata doeMetadata) {
  		System.out.println("DoeMetadata Journal Title : " + doeMetadata.getJournalTitle());
  		System.out.println("doeMetadata.getDoeId() : " + doeMetadata.getDoeId());
  		DoeMetadata doeMetadataObj = new DoeMetadata();
  		BeanUtils.copyProperties(doeMetadata, doeMetadataObj);
  		//doeMetadataObj.setDoeMetadataId(1L);
//  		System.out.println("doeMetadataObj.getDoeMetadataId() : " + doeMetadataObj.getDoeMetadataId());
//  		System.out.println("doeMetadataObj.getAddress().getZip4() : " + doeMetadataObj.getAddress().getZip4());
  		doeMetadataService.updateDoeMetadata(doeMetadataObj);
  		
  		DoeMetadata ob = new DoeMetadata();
  		BeanUtils.copyProperties(doeMetadataObj, ob);
  		return new ResponseEntity<DoeMetadata>(ob, HttpStatus.OK);
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
    @PutMapping("/doeMetadata/update/{id}")
    public ResponseEntity<DoeMetadata> updateDoeMetadata(@PathVariable(value = "id") Long doeMetadataId, @RequestBody DoeMetadata doeMetadataDetails) {
    	Optional<DoeMetadata> doeMetadata = doeMetadataRepository.findById(doeMetadataId);
    	System.out.println(doeMetadata.get().getDoeId());
    	System.out.println(doeMetadata.get().getJournalTitle());
//      @Valid @RequestBody DoeMetadata employeeDetails) throws ResourceNotFoundException {
    	//DoeMetadata doeMetadata = doeMetadataRepository.findById(doeMetadataId)
//     .orElseThrow(() -> new ResourceNotFoundException("DoeMetadata not found for this id :: " + doeMetadataId));
 		//DoeMetadata doeMetadataObj = new DoeMetadata();
    	doeMetadataDetails.setDoeId(doeMetadata.get().getDoeId());
//  		BeanUtils.copyProperties(doeMetadata, doeMetadataObj);
    	BeanUtils.copyProperties(doeMetadata.get(), doeMetadataDetails);
    	
//  		System.out.println(doeMetadataObj.getAddress().getZip4());
//    	System.out.println("doeMetadata.get().getId() --> " + doeMetadata.get().getId());
//    	System.out.println("doeMetadataDetails.getDivisionCageCode() --> " + doeMetadataDetails.getDivisionCageCode());
//    	System.out.println("doeMetadataDetails.getPoc().getFirstName() --> " + doeMetadataDetails.getPoc().getFirstName());
//    	System.out.println("doeMetadataDetails.getPoc().getLastName() --> " + doeMetadataDetails.getPoc().getLastName());
//    	System.out.println("doeMetadataDetails.getPoc().getPhone() --> " + doeMetadataDetails.getPoc().getPhone());
//    	System.out.println("doeMetadataDetails.getPoc().getEmail() --> " + doeMetadataDetails.getPoc().getEmail());
//     final DoeMetadata updatedDoeMetadata = doeMetadataRepository.save(doeMetadataObj);
    	// Set ID 
    	doeMetadataDetails.setDoeId(doeMetadata.get().getDoeId());
    	System.out.println("doeMetadataDetails.getId() --> " + doeMetadataDetails.getDoeId());
    	final DoeMetadata updatedDoeMetadata = doeMetadataRepository.save(doeMetadataDetails);
     return ResponseEntity.ok(updatedDoeMetadata);
    }

}
