package it.unisa.control;

import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.unisa.bean.ProdottoBean;
import it.unisa.model.ProdottoManager;
import it.unisa.model.ProdottoManagerDM;
import it.unisa.model.RiparazioneManager;
import it.unisa.model.RiparazioneManagerDM;

/**
 * Servlet implementation class PrenotazioneRiparazioneControl
 */
@WebServlet("/PrenotazioneRiparazioneControl")
public class PrenotazioneRiparazioneControl extends HttpServlet {
	private static final long serialVersionUID = 1L;
	static RiparazioneManager riparazioneModel = new RiparazioneManagerDM();
	static ProdottoManager<ProdottoBean> merceModel = new ProdottoManagerDM();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PrenotazioneRiparazioneControl() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userRoles =(String)request.getSession().getAttribute("userRoles");
		
		 if(userRoles == null || !userRoles.equalsIgnoreCase("cliente")){
		    	response.sendRedirect("./login.jsp");
				return;
		    }
		 
		String codiceUtente = (String)request.getSession().getAttribute("codiceFiscale");
		String data = (String)request.getParameter("dateRiparazioni");
		
		SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd");
		java.util.Date date = null;
		try {
			date = sdf1.parse(data);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		java.sql.Date sqlData = new java.sql.Date(date.getTime());
		
		String categoria = (String) request.getParameter("categoria");
		String descrizione = (String) request.getParameter("descrizione");
		
		ProdottoBean prodotto = new ProdottoBean();
		prodotto.setTipo(categoria);
		prodotto.setDescrizione(descrizione);
		
		
		try {
			merceModel.doSave(prodotto);
			prodotto.setIdProdotto(merceModel.doRetrieveLastKey());
			riparazioneModel.doSaveRiparazione(prodotto, sqlData, codiceUtente);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/index.jsp");
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
