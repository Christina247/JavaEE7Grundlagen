package de.video2brain.javaee7.cdi.decorators;

import java.util.List;

import javax.annotation.Priority;
import javax.decorator.Decorator;
import javax.decorator.Delegate;
import javax.enterprise.context.Dependent;
import javax.enterprise.inject.Any;
import javax.inject.Inject;
import javax.interceptor.Interceptor;

import de.video2brain.javaee7.cdi.KontakteHandler;

@Decorator
//@Priority(Interceptor.Priority.APPLICATION + 100)
@Dependent
public class KontakteDecorator implements KontakteHandler {

	@Inject
	@Any
	@Delegate
	private KontakteHandler handler;
	
	@Override
	public List<String> getKontakteNamen() {
		List<String> namen = handler.getKontakteNamen();
		namen.add("==> DECORATOR <==");
		
		return namen;
	}

}
