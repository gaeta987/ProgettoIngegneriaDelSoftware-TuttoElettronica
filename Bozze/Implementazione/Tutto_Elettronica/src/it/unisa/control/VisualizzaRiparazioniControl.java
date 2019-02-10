package it.unisa.control;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import it.unisa.model.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class VisualizzaRiparazioniControl
 */
@WebServlet("/VisualizzaRiparazioniControl")
public class VisualizzaRiparazioniControl extends HttpServlet {
	private static final long serialVersionUID = 1L;
	static RiparazioneManager riparazioneModel = new RiparazioneManagerDM();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public VisualizzaRiparazioniControl() {
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
	    
	    ArrayList<ProdottoInRiparazioneBean> prodottiInRiparazione = new ArrayList<ProdottoInRiparazioneBean>();
	    
	   try {
		prodottiInRiparazione = (ArrayList<ProdottoInRiparazioneBean>) riparazioneModel.doRetrieveAllRiparazioni();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	   
	   request.setAttribute("prodottiInRiparazione", prodottiInRiparazione);
	   RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/modificaStatoRiparazioneBoundary.jsp");
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
