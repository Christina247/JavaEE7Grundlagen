package de.video2brain.javaee.jsf;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.inject.Named;

import de.video2brain.javaee.jsf.bl.UserHandler;

@Named
@ApplicationScoped
public class NavigationBean {

	@Inject private UserHandler userHandler;
	
	public String showUsers() {
		if(userHandler.getUsers().size() > 0) {
			return "success";
		}
		
		return "failure";
	}
	
}
