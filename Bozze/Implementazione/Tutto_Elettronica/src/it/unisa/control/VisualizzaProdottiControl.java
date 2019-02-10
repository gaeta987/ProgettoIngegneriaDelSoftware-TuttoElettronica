package it.unisa.control;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.unisa.model.ProdottoManager;
import it.unisa.model.ProdottoManagerDM;
import it.unisa.model.ProdottoInMagazzinoBean;

/**
 * Servlet implementation class VisualizzaProdottiControl
 */
@WebServlet("/VisualizzaProdottiControl")
public class VisualizzaProdottiControl extends HttpServlet {
	private static final long serialVersionUID = 1L;
	static ProdottoManager merceModel = new ProdottoManagerDM();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public VisualizzaProdottiControl() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 String userRoles =(String)request.getSession().getAttribute("userRoles");
		   
		    
		 if(userRoles != null || userRoles.equalsIgnoreCase("gestoreProdotti") || userRoles.equals("admin")){
		    	
		    }else{
		    	response.sendRedirect("./login.jsp");
				return;
		    }
		    
		    ArrayList<ProdottoInMagazzinoBean> prodotti = new ArrayList<ProdottoInMagazzinoBean>();
		    try {
				prodotti = (ArrayList<ProdottoInMagazzinoBean>) merceModel.doRetrieveAll();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		    
		    request.setAttribute("prodottiInMagazzino", prodotti);
		    RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/visualizzaProdottiBoundary.jsp");
			dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
