package it.unisa.control;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.unisa.bean.ProdottoBean;
import it.unisa.bean.ProdottoInMagazzinoBean;
import it.unisa.model.ProdottoManager;
import it.unisa.model.ProdottoManagerDM;

/**
 * Servlet implementation class VisualizzaModificheProdottoControl
 */
@WebServlet("/VisualizzaModificheProdottoControl")
public class VisualizzaModificheProdottoControl extends HttpServlet {
	private static final long serialVersionUID = 1L;
	static ProdottoManager merceModel = new ProdottoManagerDM();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public VisualizzaModificheProdottoControl() {
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
	    
	    int id = Integer.parseInt(request.getParameter("id"));
	    
	    ProdottoInMagazzinoBean prodotto = new ProdottoInMagazzinoBean();
	    
	    try {
			prodotto = (ProdottoInMagazzinoBean) merceModel.doRetrieveByKey(id, "prodottoinmagazzino");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    
	    request.setAttribute("prodottoDaModificare", prodotto);
	    
	    RequestDispatcher view = getServletContext().getRequestDispatcher("/modificaProdottoBoundary.jsp");
		view.forward(request, response);
	    
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
