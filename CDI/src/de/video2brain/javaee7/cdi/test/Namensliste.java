package de.video2brain.javaee7.cdi.test;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.Dependent;
import javax.inject.Inject;

import de.video2brain.javaee7.cdi.KontakteProvider;
import de.video2brain.javaee7.cdi.qualifier.Test;

@Dependent
public class Namensliste {

	private List<String> namen;
	
	@Inject @Test
	private KontakteProvider kontakteProvider;
	
	@PostConstruct
	private void initialize() {
		namen = kontakteProvider.getKontaktNamen();
		namen.add("==> Namensliste!!! <==");
	}
	
	public List<String> getNamen() {
		return namen;
	}
	
}
