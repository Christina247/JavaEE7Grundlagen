package de.video2brain.javaee7.cdi;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.enterprise.context.Dependent;
import javax.enterprise.context.SessionScoped;
import javax.enterprise.inject.Produces;
import javax.inject.Inject;

import de.video2brain.javaee7.cdi.qualifier.Test;
import de.video2brain.javaee7.cdi.test.TestKontakteProvider;

@Dependent
public class KontakteProviderFactory {

	@Inject
	private TestKontakteProvider testProvider;
	
	@Produces @Test @SessionScoped
	public KontakteProvider getProvider() {
		
		TestKontakteProvider provider = new TestKontakteProvider();
		provider.getKontaktNamen().add("Johannes");
		provider.getKontaktNamen().add("Noah");
		
		final SimpleDateFormat format = new SimpleDateFormat("HH:mm:ss");
		provider.getKontaktNamen().add(format.format(new Date()));
		
		return provider;
		
	}
	
}
