package presentation;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Conseiller;
import persistence.RequeteSQL;

/**
 * Servlet implementation class ServletAjoutConseiller
 */
@WebServlet("/ServletAjoutConseiller")
public class ServletAjoutConseiller extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletAjoutConseiller() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//Recupération des paramètres
		String id=request.getParameter("id");
		String nom=request.getParameter("nom");
		String prenom=request.getParameter("prenom");
		String age=request.getParameter("age");
		
		
		//Instanciation d'un conseiller
		Conseiller cons= new Conseiller(Integer.parseInt(id),nom,prenom,Integer.parseInt(age));
		cons.setNom(nom);
			RequeteSQL.sauverEnBase(cons);//Erreur SQL
		//Insertion du conseiller dans la requête Http et transfert vers la jsp
		request.setAttribute("conseiller", cons);
		RequestDispatcher dispatch=request.getRequestDispatcher("nouveau_conseiller.jsp");
		dispatch.forward(request, response);
	}

}
