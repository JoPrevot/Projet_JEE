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
import model.Livre;


@WebServlet("/ajouterLivre")
public class AjouterLivre extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private Dao<Livre> livreDao;
	private Dao<Auteur> auteurDao;
    
    public AjouterLivre() {
        super();
        livreDao = DaoFactory.getInstance().getLivreDao();  
        auteurDao = DaoFactory.getInstance().getAuteurDao();  
        }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	try 
	{
		request.setAttribute("auteurs", auteurDao.lister());
	} 
	catch (DaoException e) 
	{
		e.printStackTrace();
	}	
			
	
		this.getServletContext().getRequestDispatcher("/WEB-INF/ajouterLivre.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String idAuteurReq = request.getParameter("idAuteurLivre");
		String titre = request.getParameter("titreLivre");
		String nbPagesReq = request.getParameter("nbPagesLivre");
		String categorie = request.getParameter("categorieLivre");
		
		Livre livre = new Livre();
		
		long idAuteur = Long.parseLong(idAuteurReq);
		
		int nbPages = Integer.parseInt(nbPagesReq);
		
		Auteur auteur = null;
		
		try 
		{
			auteur = auteurDao.trouver(idAuteur);
			
			livre.setAuteur(auteur);
			livre.setTitre(titre);
			livre.setNbPages(nbPages);
			livre.setCategorie(categorie);
			
			livreDao.creer(livre);
		} 
		catch (DaoException e) 
		{
			e.printStackTrace();
		}
		
		response.sendRedirect(request.getContextPath()+"/liste-livres");	
		
	}

}
