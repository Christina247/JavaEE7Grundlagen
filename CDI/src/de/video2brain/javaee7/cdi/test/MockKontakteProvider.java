package de.video2brain.javaee7.cdi.test;

import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.Dependent;
import javax.enterprise.inject.Alternative;

import de.video2brain.javaee7.cdi.qualifier.Test;
import de.video2brain.javaee7.cdi.KontakteProvider;

@Dependent
@Test
@Alternative
public class MockKontakteProvider extends KontakteProvider {

	@Override
	public List<String> getKontaktNamen() {
		
		ArrayList<String> namen = new ArrayList<String>();
		namen.add("TEST - Peter");
		namen.add("TEST - Tester");
		namen.add("TEST - Sonnenschein");
		
		return namen;
	}
	
}
