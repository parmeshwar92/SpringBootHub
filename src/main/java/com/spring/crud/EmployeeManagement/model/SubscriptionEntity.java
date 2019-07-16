package com.spring.crud.EmployeeManagement.model;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name = "SUBSCRIPTION", uniqueConstraints = {
		@UniqueConstraint(columnNames = "ID")})
public class SubscriptionEntity implements Serializable {
	private static final long serialVersionUID = -6790693372846798580L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID",unique = true, nullable = false)
	private Long subscriptionId;

	@Column(name = "sub_name", unique = true, nullable = false, length = 100)
	private String subscriptionName;

	@JsonBackReference
	@ManyToMany(mappedBy= "subscriptions")
	private Set<Employee> employee;

	public SubscriptionEntity() {

	} 
	public SubscriptionEntity(Long subscriptionId, String subscriptionName, Set<Employee> employee) {
		super();
		this.subscriptionId = subscriptionId;
		this.subscriptionName = subscriptionName;
	}

	public Long getSubscriptionId() {
		return subscriptionId;
	}

	public void setSubscriptionId(Long subscriptionId) {
		this.subscriptionId = subscriptionId;
	}

	public String getSubscriptionName() {
		return subscriptionName;
	}

	public void setSubscriptionName(String subscriptionName) {
		this.subscriptionName = subscriptionName;
	}

	public Set<Employee> getEmployee() {
		return employee;
	}

	public void setEmployee(Set<Employee> employee) {
		this.employee = employee;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "SubscriptionEntity [subscriptionId=" + subscriptionId + ", subscriptionName=" + subscriptionName
				+ ", employee=" + employee + "]";
	}

}
