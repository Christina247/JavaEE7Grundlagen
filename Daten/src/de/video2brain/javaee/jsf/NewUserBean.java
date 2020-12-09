package de.video2brain.javaee.jsf;
import java.io.Serializable;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Named
@RequestScoped
public class NewUserBean implements Serializable {

	@NotNull(message = "Bitte geben Sie einen Anmeldenamen an!")
	@Size(min=3, max=10, message="Die Länge muss zwischen 3 und 10 Zeichen betragen!")
	private String loginName;
	
	private String password;
	
	private Gender gender;
	
	private boolean showThankYouMessage = false;

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

	public boolean isShowThankYouMessage() {
		return showThankYouMessage;
	}

	public void setShowThankYouMessage(boolean showThankYouMessage) {
		this.showThankYouMessage = showThankYouMessage;
	}
		
}
