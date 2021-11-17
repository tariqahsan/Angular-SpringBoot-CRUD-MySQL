package org.mma.training.java.spring.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
//import static org.apache.commons.lang3.StringEscapeUtils.escapeJava;

import org.hibernate.annotations.GenericGenerator;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Point of Contact entity
 * 
 * @author EDuffy
 * 
 */
@Entity
@Table( name = "point_of_contact")
public class PointOfContact implements Serializable {
	
	private static final long serialVersionUID = -5648975837104226578L;
	
//	@Id
//	@GeneratedValue
//	@Column( name = "POC_ID")
//	private Long id;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
	@GenericGenerator(name = "native", strategy = "native")
	@Column(name = "POC_ID", updatable = false, nullable = false)
	private Long id;
	
	@Column( name = "LAST_NAME")
	private String lastName;
	
	@Column( name = "FIRST_NAME")
	private String firstName;
	
	@Column( name = "PHONE")
	private String phone;
	
	@Column( name = "EMAIL")
	private String email;
	
//	@OneToOne(fetch = FetchType.LAZY, mappedBy = "poc")
//	@JsonBackReference
//	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
//	private PinRequest pinRequest;
//	
	@OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@MapsId
	@JoinColumn(name = "ID")
	@JsonBackReference
	private PinRequest pinRequest;
	
	public PinRequest getPinRequest() {
		return pinRequest;
	}

	public void setPinRequest(PinRequest pinRequest) {
		this.pinRequest = pinRequest;
	}

	//	@ManyToOne( )
//	@JoinColumn( name = "POC_TYPE_ID")
//	private PointOfContactType pointOfContactType;
//	
//	@OneToMany( cascade = CascadeType.MERGE , fetch = FetchType.LAZY)
//	@JoinColumn( name = "SUBMITTER_POC_ID")
//	private List<Project> projects = new ArrayList<Project>();
//	
//	@OneToMany( cascade = CascadeType.ALL , fetch = FetchType.LAZY)
//	@JoinColumn( name = "POC_ID")
//	private List<CageCodePoc> cageCodePocList = new ArrayList<CageCodePoc>();
//	
	public String getPhone() {
		return phone;
	}
	
	public void setPhone( String phone ) {
		this.phone = phone;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail( String email ) {
		this.email = email;
	}
	
	public Long getId() {
		return id;
	}
	
	public void setId( Long id ) {
		this.id = id;
	}
	
	public String getLastName() {
		return lastName;
	}
	
	public void setLastName( String lastName ) {
		this.lastName = lastName;
	}
	
	public String getFirstName() {
		return firstName;
	}
	
	public void setFirstName( String firstName ) {
		this.firstName = firstName;
	}
	
//	@Override
//	public String toString() {
//		return "PointOfContact [email=" + escapeJava(email) + ", firstName=" + escapeJava(firstName) + ", id=" + id + ", lastName=" + escapeJava(lastName) + ", phone=" + escapeJava(phone) + ", pointOfContactType=" + pointOfContactType + "]";
//	}
	
//	public List<Project> getProjects() {
//		return projects;
//	}
//	
//	public void setProjects( List<Project> projects ) {
//		if( projects != null ) this.projects.clear();
//		this.projects = projects;
//	}
//	
//	public PointOfContactType getPointOfContactType() {
//		return pointOfContactType;
//	}
//	
//	public void setPointOfContactType( PointOfContactType pointOfContactType ) {
//		this.pointOfContactType = pointOfContactType;
//	}
//	
//	public List<CageCodePoc> getCageCodePocList() {
//		return cageCodePocList;
//	}
//	
//	public void setCageCodePocList( List<CageCodePoc> cageCodePocList ) {
//		if( cageCodePocList != null ) cageCodePocList.clear();
//		this.cageCodePocList = cageCodePocList;
//	}
	
}
