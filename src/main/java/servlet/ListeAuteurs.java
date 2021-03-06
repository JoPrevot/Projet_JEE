package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.Dao;
import dao.DaoException;
import dao.DaoFactory;
import model.Auteur;


@WebServlet("/liste-auteurs")
public class ListeAuteurs extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Dao<Auteur> auteurDao;
       
    
    public ListeAuteurs() {
        super();
        
        auteurDao = DaoFactory.getInstance().getAuteurDao();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		var idStr=request.getParameter("id");
		
		if(idStr==null) 
		{
			List<Auteur> auteurs=null;
			try 
			{
				auteurs = auteurDao.lister();
			} 
			catch (DaoException e) 
			{
				e.printStackTrace();
			}
			
			request.setAttribute("auteurs", auteurs);
			
			this.getServletContext().getRequestDispatcher("/WEB-INF/ListeAuteurs.jsp").forward(request, response);
		} 
		else 
		{
			var id = Long.parseLong(idStr);
			
			try 
			{
				var auteur = auteurDao.trouver(id);
				
				request.setAttribute("auteur", auteur);
				
				this.getServletContext().getRequestDispatcher("/WEB-INF/DetailsAuteur.jsp").forward(request, response);
			} 
			catch (DaoException e) 
			{
				e.printStackTrace();
			}
		}
		
	}

}
