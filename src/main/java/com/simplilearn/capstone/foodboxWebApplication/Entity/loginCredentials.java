package com.simplilearn.capstone.foodboxWebApplication.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
@Table(name="logincredentials")
public class loginCredentials 
{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "id")
	private long loginid;
	
	@Column(name = "username")
	private String username;
	
	@Column(name = "userpassword")
	private String pword;
	
	@Column(name = "userrole")
	private String role;
	
	@Column(name = "accstatus")
	private String accountstatus;

	@JsonIgnore
	@OneToOne(mappedBy="userCredentials")
	private userInfo userinfo;
	
	public loginCredentials()
	{
		
	}

	public loginCredentials(String username, String password, String role, String accountstatus) {
		super();
		this.username = username;
		this.pword = password;
		this.role = role;
		this.accountstatus = accountstatus;
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

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getAccountstatus() {
		return accountstatus;
	}

	public void setAccountstatus(String accountstatus) {
		this.accountstatus = accountstatus;
	}

	public long getLoginid() {
		return loginid;
	}

	@Override
	public String toString() {
		return "loginCredentials [loginId=" + loginid + ", username=" + username + ", pword=" + pword + ", role=" + role
				+ ", accountstatus=" + accountstatus + ", userinfo=" + userinfo + "]";
	}

}
