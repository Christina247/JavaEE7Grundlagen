package de.video2brain.javaee7.cdi;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.enterprise.context.Dependent;
import javax.enterprise.inject.Produces;

@Dependent
public class KontakteProvider {

	@Produces
	private final List<String> standardKontakte;
	
	public KontakteProvider() {
		standardKontakte = 
			new ArrayList<String>(
				Arrays.asList(
					new String[] { "Peter", "Klaus", "Michi"}));
	}
	
	public List<String> getKontaktNamen() {
		return standardKontakte; 
	}
	
}
