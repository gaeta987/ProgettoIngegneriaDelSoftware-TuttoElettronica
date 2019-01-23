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

import it.unisa.model.MerceModel;
import it.unisa.model.MerceModelDM;
import it.unisa.model.ProdottoBean;

/**
 * Servlet implementation class Attivit‡AccountControl
 */
@WebServlet("/Attivit‡AccountControl")
public class Attivit‡AccountControl extends HttpServlet {
	private static final long serialVersionUID = 1L;
	static MerceModel<ProdottoBean> merceModel = new MerceModelDM();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Attivit‡AccountControl() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String tipoProdotto = (String) request.getParameter("tipoProdotto");
		String codiceFiscale = (String) request.getSession().getAttribute("codiceFiscale");
		
		String redirectPage="";
		if(tipoProdotto.equalsIgnoreCase("prodottoinriparazione"))
			redirectPage="/prodottiRiparatiBoundary.jsp";
		else
			redirectPage="/prodottiPrenotatiBoundary.jsp";
		
		ArrayList<ProdottoBean> prodotti = new ArrayList<ProdottoBean>();
		
		try {
			prodotti = (ArrayList<ProdottoBean>)merceModel.doRetrieveByCodiceFiscale(codiceFiscale, tipoProdotto);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		request.setAttribute("prodottiDaVisualizzare", prodotti);
		
		RequestDispatcher view = getServletContext().getRequestDispatcher(redirectPage);
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
