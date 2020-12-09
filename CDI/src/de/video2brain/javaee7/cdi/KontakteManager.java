package de.video2brain.javaee7.cdi;

import java.io.Serializable;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.enterprise.event.Observes;
import javax.inject.Inject;

import de.video2brain.javaee7.cdi.interceptors.Logging;
import de.video2brain.javaee7.cdi.qualifier.Test;

@RequestScoped
public class KontakteManager implements Serializable, KontakteHandler {
	
	@Inject @Test
	private KontakteProvider kontakteProvider;
	
	/* (non-Javadoc)
	 * @see de.video2brain.javaee7.cdi.KontakteHandler#getKontakteNamen()
	 */
	@Override
	public List<String> getKontakteNamen() {
		return kontakteProvider.getKontaktNamen();
	}

}
