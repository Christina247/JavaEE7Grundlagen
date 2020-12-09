

import java.io.IOException;
import java.io.PrintWriter;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import de.video2brain.javaee.ejblite.BookHandler;
import de.video2brain.javaee.entities.Book;

/**
 * Servlet implementation class BooksServlet
 */
@WebServlet("/BooksServlet")
public class BooksServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	@EJB
	private BookHandler bookHandler;
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BooksServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		out.write("<h1>Deine Bücher</h1>");
		out.write("<ul>");
		for(Book book : bookHandler.getBooks()) {
			out.write("<li>");
			out.write(book.getTitle() + " (" + book.getYear() + ")");
			out.write("</li>");
		}
		out.write("</ul>");
	}

}
