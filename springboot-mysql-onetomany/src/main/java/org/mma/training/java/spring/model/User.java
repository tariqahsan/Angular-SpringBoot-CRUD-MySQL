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

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "USERS")
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
	@GenericGenerator(name = "native", strategy = "native")
	@Column(name = "USER_ID", updatable = false, nullable = false)
	private Long userId;
	
	@Column(name = "FIRST_NAME")
	private String firstName;
	
	@Column(name = "MIDDLE_NAME")
	private String middleName;
	
	@Column(name = "LAST_NAME")
	private String lastName;
	
	@Column(name = "PHONE_NUMBER")
	private String phone;
	
	@Column(name = "EMAIL_ADDRESS")
	private String email;
	
	@OneToOne(mappedBy = "user", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JsonManagedReference
	private Address address;
	
	public User() {}

	public User(String firstName, String middleName, String lastName, String phone, String email, Address address) {
		super();
		this.firstName = firstName;
		this.middleName = middleName;
		this.lastName = lastName;
		this.phone = phone;
		this.email = email;
		this.address = address;
	}
	
	public User(String firstName, String middleName, String lastName, String phone, String email) {
		super();
		this.firstName = firstName;
		this.middleName = middleName;
		this.lastName = lastName;
		this.phone = phone;
		this.email = email;;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getMiddleName() {
		return middleName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Address getAddress() {
		return address;
	}

//	public void setAddress(Address address) {
//		if(address == null) {
//			if(this.address != null) {
//				this.address.setUser(null);
//			}
//		} else {
//			this.address.setUser(this);
//		}
//		this.address = address;
//	}
	
	public void setAddress(Address address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "User [userId=" + userId + ", firstName=" + firstName + ", middleName=" + middleName + ", lastName="
				+ lastName + ", phone=" + phone + ", email=" + email + ", address=" + address + "]";
	}
	
}
