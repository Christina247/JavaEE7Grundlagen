package de.video2brain.javaee.cdi;

import java.io.Serializable;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.context.SessionScoped;

import de.video2brain.javaee.ejblite.StatefulBean;

@SessionScoped
public class BeanManager implements Serializable {

	@EJB
	private StatefulBean statefulBean;
	
	public void erhoeheZugriffe() {
		statefulBean.erhoeheZugriffe();
	}
	
	public int getZugriffe() {
		return statefulBean.getZugriffe();
	}
	
}
