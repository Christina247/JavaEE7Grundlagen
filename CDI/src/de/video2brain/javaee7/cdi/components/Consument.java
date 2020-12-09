package de.video2brain.javaee7.cdi.components;

import javax.enterprise.context.Dependent;
import javax.enterprise.event.Observes;

@Dependent
public class Consument {

	private void onElementAdded(@Observes String added) {
		System.out.println("==>" + added + " wurde hinzugefügt!");
	}
	
}
