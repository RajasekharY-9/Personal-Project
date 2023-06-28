package com.infymemobileuser.dto;


import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.time.LocalDate;

 

public class UserDTO {
    @NotNull(message = "Mobile number cannot be null")
    @Size(min = 10, max = 10, message = "Mobile number must be 10 digits")
    private Long mobileNumber;

 

    @Pattern(regexp = "^U.*", message = "User ID must start with 'U'")
    private String userId;

 

    @NotNull(message = "Account holder name cannot be null")
    @Size(min = 3, max = 50, message = "Account holder name length must be between 3 and 50")
    private String accountHolderName;

 

    @Pattern(regexp = "^(Male|Female)$", message = "Gender must be Male or Female")
    private String gender;

 

    @Past(message = "Date of birth must be a past date")
    private LocalDate dateOfBirth;

 

    @NotNull(message = "Password cannot be null")
    @Size(min = 5, max = 10, message = "Password length must be between 5 and 10")
    private String password;

 

    @Pattern(regexp = "^[\\w.]+@[\\w.]+$", message = "Email format is invalid")
    private String email;

 

    @NotNull(message = "Communication address cannot be null")
    @Size(min = 3, max = 50, message = "Communication address length must be between 3 and 50")
    private String communicationAddress;

 

    @NotNull(message = "PAN cannot be null")
    @Size(max = 10, message = "PAN length must not exceed 10")
    @Pattern(regexp = "^[A-Z]{5}\\d{4}[A-Z]$", message = "PAN format is invalid")
    private String PAN;

 

    // Constructors, getters, and setters

 

    public UserDTO() {
        // Default constructor
    }

 

    // Add constructors with parameters if needed

 

    // Getters and setters for all variables

 

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

 

    public void setPAN(String PAN) {
        this.PAN = PAN;
    }
}