package de.video2brain.javaee7.cdi.interceptors;

import javax.annotation.Priority;
import javax.enterprise.context.Dependent;
import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;

@Interceptor
@Logging
@Priority(Interceptor.Priority.APPLICATION + 200)
@Dependent
public class LoggingInterceptor {

	@AroundInvoke
	public Object log(InvocationContext context) throws Exception {
		String name = context.getMethod().getName();
		System.out.println("==> " + name);
		
		Object result = context.proceed();
		
		System.out.println("<== " + name);
		
		return result;
	}
	
}
