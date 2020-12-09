

import java.io.IOException;

import javax.ejb.EJB;
import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import de.video2brain.javaee.cdi.BeanManager;
import de.video2brain.javaee.ejblite.StatefulBean;

/**
 * Servlet implementation class StatefulServlet
 */
@WebServlet("/StatefulServlet")
public class StatefulServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	@Inject
	private BeanManager statefulBean;
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StatefulServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		statefulBean.erhoeheZugriffe();
		
		response.getWriter().write("<h1>Dein " + statefulBean.getZugriffe() + ". Zugriff!</h1>");
	}

}
