package com.simplilearn.capstone.foodboxWebApplication.Dto;

public class Userdetails 
{

	private String firstname;
	private String lastname;
	private String emailId;
	private String contactNo;
	private String address;
	private String username;
	private String pword;
	
	public Userdetails()
	{
		
	}
	
	public Userdetails(String firstname, String lastname, String emailId, String contactNo, String address,
			String username, String pword) {
		super();
		this.firstname = firstname;
		this.lastname = lastname;
		this.emailId = emailId;
		this.contactNo = contactNo;
		this.address = address;
		this.username = username;
		this.pword = pword;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getContactNo() {
		return contactNo;
	}

	public void setContactNo(String contactNo) {
		this.contactNo = contactNo;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPword() {
		return pword;
	}

	public void setPword(String pword) {
		this.pword = pword;
	}

	@Override
	public String toString() {
		return "Userdetails [firstname=" + firstname + ", lastname=" + lastname + ", emailId=" + emailId
				+ ", contactNo=" + contactNo + ", address=" + address + ", username=" + username + ", pword=" + pword
				+ "]";
	}
	
}
