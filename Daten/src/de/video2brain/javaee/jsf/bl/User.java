package de.video2brain.javaee.jsf.bl;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import de.video2brain.javaee.jsf.Gender;

public class User {

	private String loginName;

	private String password;
	
	private Gender gender;

	public User() { }
	
	public User(String loginName, String password, Gender gender) {
		super();
		this.loginName = loginName;
		this.password = password;
		this.gender = gender;
	}

	public String getLoginName() {
		return loginName;
	}

	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Gender getGender() {
		return gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}
	
	
	
}
