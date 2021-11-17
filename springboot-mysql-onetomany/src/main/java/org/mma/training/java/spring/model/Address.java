package org.mma.training.java.spring.model;

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

import org.hibernate.annotations.GenericGenerator;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name = "ADDRESS")
public class Address {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
	@GenericGenerator(name = "native", strategy = "native")
	@Column(name = "ADDRESS_ID", updatable = false, nullable = false)
	private Long id;
	
	@Column(name = "STREET_1")
	private String street1;
	
	@Column(name = "STREET_2")
	private String street2;
	
	@Column(name = "CITY")
	private String city;
	
	@Column(name = "STATE")
	private String state;
	
	@Column(name = "ZIP5")
	private String zip5;
	
	@Column(name = "ZIP4")
	private String zip4;
	
	@OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@MapsId
	@JoinColumn(name = "ID")
	@JsonBackReference
    private User user;
	
	public Address() {}

	public Address(String street1, String street2, String city, String state, String zip5, String zip4) {
		super();
		this.street1 = street1;
		this.street2 = street2;
		this.city = city;
		this.state = state;
		this.zip5 = zip5;
		this.zip4 = zip4;
	}
	
	public Address(String street1, String street2, String city, String state, String zip5, String zip4, User user) {
		super();
		this.street1 = street1;
		this.street2 = street2;
		this.city = city;
		this.state = state;
		this.zip5 = zip5;
		this.zip4 = zip4;
		this.user = user;
	}

	public Long getAddressId() {
		return id;
	}

	public void setAddressId(Long id) {
		this.id = id;
	}

	public String getStreet1() {
		return street1;
	}

	public void setStreet1(String street1) {
		this.street1 = street1;
	}

	public String getStreet2() {
		return street2;
	}

	public void setStreet2(String street2) {
		this.street2 = street2;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getZip5() {
		return zip5;
	}

	public void setZip5(String zip5) {
		this.zip5 = zip5;
	}

	public String getZip4() {
		return zip4;
	}

	public void setZip4(String zip4) {
		this.zip4 = zip4;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return "Address [id=" + id + ", street1=" + street1 + ", street2=" + street2 + ", city=" + city
				+ ", state=" + state + ", zip5=" + zip5 + ", zip4=" + zip4 + ", user=" + user + "]";
	}

}
