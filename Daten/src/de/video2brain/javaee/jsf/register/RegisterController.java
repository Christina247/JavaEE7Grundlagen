package de.video2brain.javaee.jsf.register;

import javax.enterprise.context.Dependent;
import javax.faces.flow.FlowScoped;
import javax.inject.Inject;
import javax.inject.Named;

import de.video2brain.javaee.jsf.bl.User;
import de.video2brain.javaee.jsf.bl.UserHandler;

@FlowScoped("register")
@Named
public class RegisterController {

	@Inject 
	private RegisterBean registerBean;
	
	@Inject
	private UserHandler userHandler;
	
	public String flowReturnValue() {
		
		User user = new User();
		
		user.setGender(registerBean.getGender());
		user.setLoginName(registerBean.getLoginName());
		user.setPassword(registerBean.getLoginName());
		
		userHandler.getUsers().add(user);
		
		return "register_done";
	}
	
}
