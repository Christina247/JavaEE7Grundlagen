package de.video2brain.javaee.jsf.bl;

import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.ApplicationScoped;

import de.video2brain.javaee.jsf.NewUserBean;

@ApplicationScoped
public class UserHandler {

	private ArrayList<User> users = new ArrayList<User>();
	
	public void add(NewUserBean currentUser) {
		User user = new User(currentUser.getLoginName(), currentUser.getPassword(), currentUser.getGender());
		users.add(user);
	}
	
	public List<User> getUsers() {
		return users;
	}
	
}
