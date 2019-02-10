package it.unisa.control;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.unisa.model.ProdottoManager;
import it.unisa.model.ProdottoManagerDM;

/**
 * Servlet implementation class GestisciPromozioneControl
 */
@WebServlet("/GestisciPromozioneControl")
public class GestisciPromozioneControl extends HttpServlet {
	private static final long serialVersionUID = 1L;
	static ProdottoManager merceModel = new ProdottoManagerDM();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GestisciPromozioneControl() {
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
	    
	    String action = request.getParameter("action");
	    
	    if(action.equals("add")) {
		    try {
				merceModel.doUpdatePromo(Integer.parseInt(request.getParameter("id")), action);
			} catch (NumberFormatException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	    }else {
	    	try {
				merceModel.doUpdatePromo(Integer.parseInt(request.getParameter("id")), action);
			} catch (NumberFormatException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	    }
	    
	    response.sendRedirect(request.getContextPath() + "/VisualizzaProdottiControl");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
