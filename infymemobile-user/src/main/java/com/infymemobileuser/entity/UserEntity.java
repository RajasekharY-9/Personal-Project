package com.infymemobileuser.entity;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="user")
public class UserEntity {

	
	@Id
    @Column(name = "mobile_number")
    private Long mobileNumber;

 

    @Column(name = "user_id", unique = true)
    private String userId;

 

    @Column(name = "account_holder_name", nullable = false)
    private String accountHolderName;

 

    @Column(name = "gender", nullable = false)
    private String gender;

 

    @Column(name = "date_of_birth", nullable = false)
    private LocalDate dateOfBirth;

 

    @Column(name = "password", nullable = false)
    private String password;

 

    @Column(name = "email", nullable = false)
    private String email;

 

    @Column(name = "communication_address", nullable = false)
    private String communicationAddress;

 

    @Column(name = "PAN")
    private String PAN;



	public UserEntity(Long mobileNumber, String userId, String accountHolderName, String gender, LocalDate dateOfBirth,
			String password, String email, String communicationAddress, String pAN) {
		super();
		this.mobileNumber = mobileNumber;
		this.userId = userId;
		this.accountHolderName = accountHolderName;
		this.gender = gender;
		this.dateOfBirth = dateOfBirth;
		this.password = password;
		this.email = email;
		this.communicationAddress = communicationAddress;
		PAN = pAN;
	}



	public UserEntity() {
		super();
		// TODO Auto-generated constructor stub
	}



	public Long getMobileNumber() {
		return mobileNumber;
	}



	public void setMobileNumber(Long mobileNumber) {
		this.mobileNumber = mobileNumber;
	}



	public String getUserId() {
		return userId;
	}



	public void setUserId(String userId) {
		this.userId = userId;
	}



	public String getAccountHolderName() {
		return accountHolderName;
	}



	public void setAccountHolderName(String accountHolderName) {
		this.accountHolderName = accountHolderName;
	}



	public String getGender() {
		return gender;
	}



	public void setGender(String gender) {
		this.gender = gender;
	}



	public LocalDate getDateOfBirth() {
		return dateOfBirth;
	}



	public void setDateOfBirth(LocalDate dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}



	public String getPassword() {
		return password;
	}



	public void setPassword(String password) {
		this.password = password;
	}



	public String getEmail() {
		return email;
	}



	public void setEmail(String email) {
		this.email = email;
	}



	public String getCommunicationAddress() {
		return communicationAddress;
	}



	public void setCommunicationAddress(String communicationAddress) {
		this.communicationAddress = communicationAddress;
	}



	public String getPAN() {
		return PAN;
	}



	public void setPAN(String pAN) {
		PAN = pAN;
	}



	@Override
	public String toString() {
		return "UserEntity [mobileNumber=" + mobileNumber + ", userId=" + userId + ", accountHolderName="
				+ accountHolderName + ", gender=" + gender + ", dateOfBirth=" + dateOfBirth + ", password=" + password
				+ ", email=" + email + ", communicationAddress=" + communicationAddress + ", PAN=" + PAN + "]";
	}	
	
	
	
	
	
	
	
	
	
	
	
}
