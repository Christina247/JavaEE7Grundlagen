package de.video2brain.javaee.jsf.register;

import javax.faces.flow.FlowScoped;
import javax.inject.Named;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import de.video2brain.javaee.jsf.Gender;

@Named
@FlowScoped("register")
public class RegisterBean {

	@NotNull(message = "Bitte geben Sie einen Anmeldenamen an!")
	@Size(min=3, max=10, message="Die Länge muss zwischen 3 und 10 Zeichen betragen!")
	private String loginName;
	
	@NotNull(message = "Bitte geben Sie ein Kennwort an!")
	@Size(min=3, max=10, message="Die Länge muss zwischen 3 und 10 Zeichen betragen!")
	private String password;
	
	private Gender gender;
	
	private boolean acceptedTerms;
	
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
	public boolean isAcceptedTerms() {
		return acceptedTerms;
	}
	public void setAcceptedTerms(boolean acceptedTerms) {
		this.acceptedTerms = acceptedTerms;
	}
}
