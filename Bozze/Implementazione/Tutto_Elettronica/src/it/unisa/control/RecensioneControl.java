package it.unisa.control;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.unisa.bean.Recensionie;
import it.unisa.model.RecensioneManager;
import it.unisa.model.RecensioneManagerDM;

/**
 * Servlet implementation class RecensioneControl
 */
@WebServlet("/RecensioneControl")
public class RecensioneControl extends HttpServlet {
	private static final long serialVersionUID = 1L;
	static RecensioneManager modelRecensione = new RecensioneManagerDM();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RecensioneControl() {
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
		 
		int voto = Integer.parseInt(request.getParameter("voto"));
		String descrizione = request.getParameter("descrizione");
		String codiceUtente = (String)request.getSession().getAttribute("codiceFiscale");
		int idProdotto = Integer.parseInt(request.getParameter("idProdotto"));
		
		
		Recensionie recensione = new Recensionie();
		recensione.setCodiceCliente(codiceUtente);
		recensione.setCodiceProdotto(idProdotto);
		recensione.setTesto(descrizione);
		recensione.setVoto(voto);
		
		try {
			modelRecensione.doSave(recensione);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		response.sendRedirect(request.getContextPath() + "/index.jsp");
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
