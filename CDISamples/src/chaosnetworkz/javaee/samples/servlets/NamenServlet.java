package chaosnetworkz.javaee.samples.servlets;

import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import chaosnetworkz.javaee.samples.cdi.KontakteManager;

/**
 * Servlet implementation class NamenServlet
 */
@WebServlet("/NamenServlet")
public class NamenServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

	//Instanzieren per CDI und nicht im Konstruktor
	//Bean discovery Modus kann auf all gesetzt sein. Wenn nicht klappt der Inject nur wenn alle
	//Typen auch eine Lebenszyklus Annotation haben z.B.: @SessionScope oder @Dependent
	@Inject
	private KontakteManager kontakteManager;
	
    /**
     * Default constructor. 
     */
    public NamenServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println( kontakteManager.getKontakteNamen() );
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

}
