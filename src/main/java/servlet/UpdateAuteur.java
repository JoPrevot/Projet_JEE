package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.Dao;
import dao.DaoException;
import dao.DaoFactory;
import model.Auteur;


@WebServlet("/updateAuteur")
public class UpdateAuteur extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private Dao<Auteur> auteurDao;

    public UpdateAuteur() 
    {
        super();
        auteurDao = DaoFactory.getInstance().getAuteurDao();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		long idAuteur = Long.parseLong(request.getParameter("id"));
		
		try
		{
			request.setAttribute("auteur", auteurDao.trouver(idAuteur));
		}
		catch (DaoException e) 
		{
			e.printStackTrace();
		}
		
		this.getServletContext().getRequestDispatcher("/WEB-INF/updateAuteur.jsp").forward(request, response);
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		String nom = request.getParameter("nomAuteur");
		String prenom = request.getParameter("prenomAuteur");
		String telephone = request.getParameter("telephoneAuteur");
		String email = request.getParameter("emailAuteur");
		String id = request.getParameter("id");
		
		Auteur auteur = new Auteur();
		
		long idAuteur = Long.parseLong(id);
		
		try
		{
			auteur = auteurDao.trouver(idAuteur);
			
			auteur.setNom(nom);
			auteur.setPrenom(prenom);
			auteur.setTelephone(telephone);
			auteur.setEmail(email);
		
			auteurDao.mettreajour(auteur);
		}
		catch (DaoException e) 
		{
			e.printStackTrace();
		}
		
		response.sendRedirect(request.getContextPath()+"/liste-auteurs");
	}

}
