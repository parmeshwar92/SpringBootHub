package com.spring.crud.EmployeeManagement.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "employees", uniqueConstraints = {
		@UniqueConstraint(columnNames = "ID"),
		@UniqueConstraint(columnNames = "EMAIL") })
public class Employee implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID", unique = true, nullable = false)
	private Long employeeId;

	@Column(name = "EMAIL", unique = true, nullable = false, length = 100)
	private String emailId;

	@Column(name = "FIRST_NAME", unique = false, nullable = false, length = 100)
	private String firstName;

	@Column(name = "LAST_NAME", unique = false, nullable = false, length = 100)
	private String lastName;

	@JsonManagedReference
	@OneToOne(fetch = FetchType.LAZY,
	cascade =  CascadeType.ALL,
	mappedBy = "employee")
	private UserProfile userProfile;

	@JsonManagedReference
	@OneToMany(mappedBy = "employee", cascade = CascadeType.ALL)
	private List<BankDetails> banksDetails = new ArrayList<BankDetails>();
	
	@JsonManagedReference
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "sub_scription_reader", joinColumns = { @JoinColumn(name = "ID") },inverseJoinColumns = { @JoinColumn(name = "SUB_ID") })
	private Set<SubscriptionEntity> subscriptions = new HashSet<>();
	
	public Employee() {

	}

	public Employee(Long employeeId, String firstName, String lastName, String emailId, UserProfile userProfile) {
		super();
		this.employeeId = employeeId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.emailId = emailId;
	}

	public UserProfile getUserProfile() {
		return userProfile;
	}

	public void setUserProfile(UserProfile userProfile) {
		this.userProfile = userProfile;
	}

	public Long getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(Long employeeId) {
		this.employeeId = employeeId;
	}

	public List<BankDetails> getBanksDetails() {
		return banksDetails;
	}

	public void setBanksDetails(List<BankDetails> banksDetails) {
		this.banksDetails = banksDetails;
	}

	public Long getId() {
		return employeeId;
	}
	public void setId(Long employeeId) {
		this.employeeId = employeeId;
	} 
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	

	public Set<SubscriptionEntity> getSubscriptions() {
		return subscriptions;
	}

	public void setSubscriptions(Set<SubscriptionEntity> subscriptions) {
		this.subscriptions = subscriptions;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "Employee [employeeId=" + employeeId + ", emailId=" + emailId + ", firstName=" + firstName
				+ ", lastName=" + lastName + ", userProfile=" + userProfile + ", banksDetails=" + banksDetails
				+ ", subscriptions=" + subscriptions + "]";
	}

	

	

}
