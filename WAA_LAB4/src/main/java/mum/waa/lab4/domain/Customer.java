package mum.waa.lab4.domain;

import java.util.Date;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;

public class Customer {

	@Size(min=6,max=50, message="name should be between 6 and 50 characters")
	@NotEmpty(message="Username should not be empty")
	@Pattern(regexp = "[a-zA-Z]*", message = "Must be Character Only")
	private String username;

	@NotEmpty(message="Address should not be empty")
	private String address;

	//@DateTimeFormat(pattern="dd-MM-yyyy")
	@Past(message="Date of Birth should be before today")
	private Date dateOfBirth;

	@Size(min = 6, max = 50, message="name should be between 6 and 50 characters")
	@NotEmpty(message="Password should not be empty")
	@Pattern(regexp = "[a-zA-Z]*",message="Must be Character Only")
	private String password;

	@NotNull(message="Sex should be selected")
	private String sex;

	public Customer() {

	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

}
