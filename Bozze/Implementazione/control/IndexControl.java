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
import it.unisa.model.ProdottoInMagazzinoBean;

/**
 * Servlet implementation class IndexControl
 */
@WebServlet("/IndexControl")
public class IndexControl extends HttpServlet {
	private static final long serialVersionUID = 1L;
	static MerceModel merceModel = new MerceModelDM();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public IndexControl() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ArrayList<ProdottoInMagazzinoBean> prodottiOnSale = new ArrayList<ProdottoInMagazzinoBean>();
		try {
			prodottiOnSale = (ArrayList<ProdottoInMagazzinoBean>) merceModel.doRetrieveOnSale();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		request.setAttribute("prodottiOnSale", prodottiOnSale);
		
		RequestDispatcher view = getServletContext().getRequestDispatcher("/index.jsp");
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
