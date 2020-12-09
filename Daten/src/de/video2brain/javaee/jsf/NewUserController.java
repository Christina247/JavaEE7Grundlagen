package de.video2brain.javaee.jsf;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.enterprise.context.SessionScoped;
import javax.faces.event.ActionEvent;
import javax.faces.model.SelectItem;
import javax.inject.Inject;
import javax.inject.Named;

import de.video2brain.javaee.jsf.bl.User;
import de.video2brain.javaee.jsf.bl.UserHandler;

@SessionScoped
@Named
public class NewUserController implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Inject 
	private NewUserBean newUserBean;
	
	@Inject
	private UserHandler userHandler;
	
	public void handleButtonClicked(ActionEvent event) {
		userHandler.add(newUserBean);
		
		newUserBean.setShowThankYouMessage(true);
	}
	
	public void addNewUser(ActionEvent event) {
		newUserBean.setShowThankYouMessage(false);
	}
	
	public List<User> getUsers() {
		return userHandler.getUsers();
	}
	
	public List<SelectItem> getGenders() {
		
		ArrayList<SelectItem> genders = new ArrayList<SelectItem>();
		
		genders.add(new SelectItem(Gender.Male.toString(), "Männlich"));
		genders.add(new SelectItem(Gender.Female.toString(), "Weiblich"));
		genders.add(new SelectItem(Gender.SomethingElse.toString(), "Unbekannt"));
		
		return genders;
	}
	
	public String getTime() {
		final SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
		return sdf.format(new Date()) + " Uhr";
	}
	
}
