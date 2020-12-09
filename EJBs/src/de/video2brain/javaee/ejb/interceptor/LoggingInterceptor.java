package de.video2brain.javaee.ejb.interceptor;

import javax.annotation.Priority;
import javax.enterprise.context.Dependent;
import javax.interceptor.AroundConstruct;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;

@Interceptor
@Logging
@Priority(Interceptor.Priority.APPLICATION)
@Dependent
public class LoggingInterceptor {

	@AroundConstruct
	public void handleConstructor(InvocationContext context) throws Exception {
		String className = context.getClass().getCanonicalName();
		System.out.println("==> BEFORE CONSTRUCT " + className);
		
		context.proceed();
		
		System.out.println("<== AFTER CONSTRUCT " + className);
	}
	
}
