package de.video2brain.javaee7.cdi.test;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.Dependent;
import javax.enterprise.event.Event;
import javax.enterprise.inject.Alternative;
import javax.enterprise.inject.Any;
import javax.inject.Inject;

import de.video2brain.javaee7.cdi.KontakteProvider;

@Dependent
@Alternative
public class TestKontakteProvider extends KontakteProvider implements Serializable {

	private ArrayList<String> namen = new ArrayList<String>();
	
	@Inject @Any
	private Event<String> event;
	
	@PostConstruct
	private void initialize() {
		add("Peter");
		add("Tester");
		add("Sonnenschein");
	}
	
	private void add(String name) {
		namen.add(name);
		event.fire(name);
	}
	
	@Override
	public List<String> getKontaktNamen() {
		return namen;
	}
}
