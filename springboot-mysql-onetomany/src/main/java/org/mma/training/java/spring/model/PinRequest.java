package org.mma.training.java.spring.model;


import java.io.Serializable;
import java.time.LocalDateTime;
//import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GenericGenerator;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;

/**
 * Form bean entity for requesting a PIN.
 * 
 * @JPeabody
 */
@Entity
@Table( name = "pin_requests")
public class PinRequest implements Serializable {
	
	private static final long serialVersionUID = 805675337871310979L;
	
	public PinRequest() {
		this.poc = new PointOfContact();
	}
	
//	@Id
//	@GeneratedValue
//	@Column( name = "PIN_REQUEST_ID")
//	private Long id;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
	@GenericGenerator(name = "native", strategy = "native")
	@Column(name = "PIN_REQUEST_ID", updatable = false, nullable = false)
	private Long id;
	
	@Column( name = "PARENT_ORG_NAME")
	private String parentOrgName;
	
	@Column( name = "PARENT_CAGE_CODE")
	private String parentCageCode;
	
	@Column( name = "DIVISION_NAME")
	private String divisionName;
	
	@Column( name = "DIVISION_CAGE_CODE")
	private String divisionCageCode;
	
//	@OneToOne
//	@JoinColumn( name = "REQUESTER_POC_ID")
//	private PointOfContact poc;
//	@OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
//	@MapsId
//	@JsonManagedReference
//	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
//	@JoinColumn(name = "REQUESTER_POC_ID")
//    private PointOfContact poc;
	
	@OneToOne(mappedBy = "pinRequest", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JsonManagedReference
	private PointOfContact poc;
		
	@Column( name = "CREATE_DT")
	@CreationTimestamp
	private LocalDateTime createDateTime;
	//private Date createDate;
	
	@Column( name = "RESPONSE_IND")
	private String responseInd;

	@Column( name = "REPLACEMENT")
	private String replacement;
	
	public Long getId() {
		return id;
	}
	
	public void setId( Long id ) {
		this.id = id;
	}
	
	public String getParentOrgName() {
		return parentOrgName;
	}
	
	public void setParentOrgName( String parentOrgName ) {
		this.parentOrgName = parentOrgName;
	}
	
	public String getParentCageCode() {
		return parentCageCode;
	}
	
	public void setParentCageCode( String parentCageCode ) {
		this.parentCageCode = parentCageCode;
	}
	
	public String getDivisionName() {
		return divisionName;
	}
	
	public void setDivisionName( String divisionName ) {
		this.divisionName = divisionName;
	}
	
	public String getDivisionCageCode() {
		return divisionCageCode;
	}
	
	public void setDivisionCageCode( String divisionCageCode ) {
		this.divisionCageCode = divisionCageCode;
	}
	
	public PointOfContact getPoc() {
		return poc;
	}
	
	public void setPoc( PointOfContact poc ) {
		this.poc = poc;
	}
	
//	public Date getCreateDate() {
//		return createDate;
//	}
//	
//	public void setCreateDate( Date createDate ) {
//		this.createDate = createDate;
//	}
	
	public String getResponseInd() {
		return responseInd;
	}
	
	public void setResponseInd( String responseInd ) {
		this.responseInd = responseInd;
	}
	
//	@Override
//	public String toString() {
//		return "PinRequest [createDate=" + createDate + ", divisionCageCode=" + divisionCageCode + ", divisionName=" + divisionName + ", id=" + id + ", parentCageCode=" + parentCageCode + ", parentOrgName=" + parentOrgName + ", poc=" + poc + ", responseInd=" + responseInd + "]";
//	}
	
	@Override
	public String toString() {
		return "PinRequest [id=" + id + ", parentOrgName=" + parentOrgName + ", parentCageCode=" + parentCageCode
				+ ", divisionName=" + divisionName + ", divisionCageCode=" + divisionCageCode + ", poc=" + poc
				+ ", createDateTime=" + createDateTime + ", responseInd=" + responseInd + ", replacement=" + replacement
				+ "]";
	}

	public String getReplacement()
	{
		return replacement;
	}

	public LocalDateTime getCreateDateTime() {
		return createDateTime;
	}

	public void setCreateDateTime(LocalDateTime createDateTime) {
		this.createDateTime = createDateTime;
	}

	public void setReplacement( String replacement )
	{
		this.replacement = replacement;
	}
	
}