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

/**
 * Servlet implementation class SupprimerLivre
 */
@WebServlet("/SupprimerLivre")

public class SupprimerLivre extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private Dao<Livre> livreDao;
	
    public SupprimerLivre() {
        super();
        livreDao = DaoFactory.getInstance().getLivreDao();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		var idStr=request.getParameter("id");
		
		var id = Long.parseLong(idStr);
		
			try 
			{				
				livreDao.supprimer(id);	
			} 
			catch (DaoException e) 
			{
				e.printStackTrace();
			}
			
			response.sendRedirect(request.getContextPath()+"/liste-livres");
	}
}
