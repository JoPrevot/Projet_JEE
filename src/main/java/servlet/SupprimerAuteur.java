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


@WebServlet("/SupprimerAuteur")
public class SupprimerAuteur extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private Dao<Auteur> auteurDao;
	
    public SupprimerAuteur() {
        super();
        auteurDao = DaoFactory.getInstance().getAuteurDao();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		var idStr=request.getParameter("id");
		
		var id = Long.parseLong(idStr);
		
			try 
			{				
				auteurDao.supprimer(id);	
			} 
			catch (DaoException e) 
			{
				e.printStackTrace();
			}
			
			response.sendRedirect(request.getContextPath()+"/liste-auteurs");
	}


}
