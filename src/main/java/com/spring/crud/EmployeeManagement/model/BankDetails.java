package com.spring.crud.EmployeeManagement.model;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name = "Bank_Info", uniqueConstraints = {
		@UniqueConstraint(columnNames = "ID")})
public class BankDetails implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID", unique = true, nullable = false)
	private Long accountId;

	@Column(name ="bank_name")
	private String name;

	@Column(name = "branch")
	private String branch;

	@Column(name ="branch_code")
	private String code;

	@JsonBackReference
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name ="user_id", nullable = false )
	private Employee employee;
	
	public Long getAccountId() {
		return accountId;
	}
	public void setAccountId(Long accountId) {
		this.accountId = accountId;
	}
	public Employee getEmployee() {
		return employee;
	}
	public void setEmployee(Employee employee) {
		this.employee = employee;
	}
	public BankDetails() {
		super();
	}
	public BankDetails(String name, String branch, String code) {
		super();
		this.name = name;
		this.branch = branch;
		this.code = code;
	}
	public Long getId() {
		return accountId;
	}
	public void setId(Long accountId) {
		this.accountId = accountId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getBranch() {
		return branch;
	}
	public void setBranch(String branch) {
		this.branch = branch;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	@Override
	public String toString() {
		return "BankDetails [accountId=" + accountId + ", name=" + name + ", branch=" + branch + ", code=" + code
				+ ", employee=" + employee + "]";
	}
	


}
