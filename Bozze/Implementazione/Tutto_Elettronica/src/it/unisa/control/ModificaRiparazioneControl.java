package it.unisa.control;

import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.unisa.model.RiparazioneManager;
import it.unisa.model.RiparazioneManagerDM;

/**
 * Servlet implementation class ModificaRiparazioneControl
 */
@WebServlet("/ModificaRiparazioneControl")
public class ModificaRiparazioneControl extends HttpServlet {
	private static final long serialVersionUID = 1L;
	static RiparazioneManager riparazioneModel = new RiparazioneManagerDM();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ModificaRiparazioneControl() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userRoles =(String)request.getSession().getAttribute("userRoles");
	    String data = request.getParameter("data");
		
	    if(userRoles == null || !userRoles.equalsIgnoreCase("gestoreRiparazioni")){
	    	response.sendRedirect("./login.jsp");
			return;
	    }
	    
	    SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd");
		java.util.Date date = null;
		
		
		String nuovoStato = request.getParameter("stato");
		int idPrenotazione = Integer.parseInt(request.getParameter("idPrenotazione"));
		
		if(data != null && !data.equalsIgnoreCase("")) {
			try {
				date = sdf1.parse(data);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			java.sql.Date nuovaData = new java.sql.Date(date.getTime());
			try {
				riparazioneModel.doUpdateData(nuovaData, idPrenotazione);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if(nuovoStato != null && !nuovoStato.equalsIgnoreCase("")) {
			try {
				riparazioneModel.doUpdateStato(nuovoStato, idPrenotazione);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		response.sendRedirect(request.getContextPath() + "/VisualizzaRiparazioniControl");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
