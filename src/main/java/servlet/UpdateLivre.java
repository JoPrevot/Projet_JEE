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


@WebServlet("/updateLivre")
public class UpdateLivre extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private Dao<Livre> livreDao;
	private Dao<Auteur> auteurDao;

    public UpdateLivre() 
    {
        super();
        livreDao = DaoFactory.getInstance().getLivreDao();
        auteurDao = DaoFactory.getInstance().getAuteurDao();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		long idLivre = Long.parseLong(request.getParameter("id"));
		
		try
		{
			request.setAttribute("livre", livreDao.trouver(idLivre));
			
			request.setAttribute("auteurs", auteurDao.lister());
		}
		catch (DaoException e) 
		{
			e.printStackTrace();
		}
		
		this.getServletContext().getRequestDispatcher("/WEB-INF/updateLivre.jsp").forward(request, response);
		
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		String idAuteurReq = request.getParameter("idAuteurLivre");
		long idAuteur = Long.parseLong(idAuteurReq);
		String titre = request.getParameter("titreLivre");
		String nbPagesReq = request.getParameter("nbPagesLivre");
		int nbPages = Integer.parseInt(nbPagesReq);
		String categorie = request.getParameter("categorieLivre");
		String idLivreReq = request.getParameter("idLivre");
		long idLivre = Long.parseLong(idLivreReq);
		
		Livre livre = new Livre();
		
		Auteur auteur = null;
		
		try
		{
			livre = livreDao.trouver(idLivre);
			auteur = auteurDao.trouver(idAuteur);
			
			livre.setAuteur(auteur);
			livre.setTitre(titre);
			livre.setNbPages(nbPages);
			livre.setCategorie(categorie);
		
			livreDao.mettreajour(livre);
		}
		catch (DaoException e) 
		{
			e.printStackTrace();
		}
		
		response.sendRedirect(request.getContextPath()+"/liste-livres");
	}

}

