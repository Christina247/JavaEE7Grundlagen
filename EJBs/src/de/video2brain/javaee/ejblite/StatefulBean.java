package de.video2brain.javaee.ejblite;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.ejb.PostActivate;
import javax.ejb.PrePassivate;
import javax.ejb.Stateful;

import de.video2brain.javaee.ejb.interceptor.Logging;

@Stateful
@Logging
public class StatefulBean {

	private int zugriffe;
	
	public void erhoeheZugriffe() {
		zugriffe++;
	}
	
	public int getZugriffe() {
		return zugriffe;
	}
	
	@PostConstruct
	private void initialize() {
		zugriffe = 1;
		
		System.out.println("==> Neue Session gestartet");
	}
	
	@PreDestroy
	private void destroy() {
		System.out.println("==> Gesamtanzahl der Zugriffe: " + zugriffe);
	}
	
	@PrePassivate
	private void beforePassivation() {
		System.out.println("==> Passivierung beginnt.");
	}
	
	@PostActivate
	private void afterActivation() {
		System.out.println("==> Aktivierung durchgeführt.");
	}
	
}
