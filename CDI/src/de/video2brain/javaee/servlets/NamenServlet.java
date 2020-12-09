package de.video2brain.javaee.servlets;

import java.io.IOException;

import javax.enterprise.event.Observes;
import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import de.video2brain.javaee7.cdi.KontakteHandler;
import de.video2brain.javaee7.cdi.KontakteProvider;
import de.video2brain.javaee7.cdi.qualifier.Test;

/**
 * Servlet implementation class NamenServlet
 */
@WebServlet("/NamenServlet")
public class NamenServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Inject 
	private KontakteHandler manager;
	
    /**
     * @see HttpServlet#HttpServlet()
     */
	public NamenServlet() {
        super();
    }
    
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	
		for(String name : manager.getKontakteNamen()) {
			response.getWriter().write(name + "<br />");
		}
	}

}
