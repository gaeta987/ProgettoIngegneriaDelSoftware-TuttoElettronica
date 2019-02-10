package it.unisa.control;

import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.unisa.model.RiparazioneManager;
import it.unisa.model.RiparazioneManagerDM;

/**
 * Servlet implementation class VisualizzaDateControl
 */
@WebServlet("/VisualizzaDateControl")
public class VisualizzaDateControl extends HttpServlet {
	private static final long serialVersionUID = 1L;
	static RiparazioneManager riparazioneModel = new RiparazioneManagerDM();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public VisualizzaDateControl() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userRoles =(String)request.getSession().getAttribute("userRoles");
	    
		if(userRoles != null || userRoles.equalsIgnoreCase("gestoreRiparazioni") || userRoles.equals("admin")){
	    	
	    }else{
	    	response.sendRedirect("./login.jsp");
			return;
	    }
	    
	    Date[] date = new Date[3];
	    
	    try {
			date = riparazioneModel.doRetrieveAll();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    
	    request.setAttribute("date", date);
	    RequestDispatcher view = getServletContext().getRequestDispatcher("/modificaDate.jsp");
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
