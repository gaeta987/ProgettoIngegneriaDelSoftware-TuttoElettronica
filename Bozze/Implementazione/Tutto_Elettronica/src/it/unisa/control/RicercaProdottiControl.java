package it.unisa.control;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.unisa.bean.ProdottoBean;
import it.unisa.bean.ProdottoInMagazzinoBean;
import it.unisa.model.*;



@WebServlet("/RicercaProdottiControl")
public class RicercaProdottiControl extends HttpServlet {
	static ProdottoManager<ProdottoBean> model = new ProdottoManagerDM();
	
      
    public RicercaProdottiControl() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		
		String ricerca = request.getParameter("search");
		
		try {
			Collection<ProdottoInMagazzinoBean> products= model.doRetrieveAll();
			ArrayList<ProdottoBean> estraction = new ArrayList<ProdottoBean>();
			if(products.size() > 0) {
				Iterator<ProdottoInMagazzinoBean> it = products.iterator();
				while(it.hasNext()) {
					ProdottoBean merce = it.next();
					if(merce.getNome().toLowerCase().contains(ricerca.toLowerCase()) || merce.getTipo().toLowerCase().contains(ricerca.toLowerCase())) {
						estraction.add(merce);
					}
				}
			}
			
			request.getSession().setAttribute("prodotti", estraction);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		RequestDispatcher view = getServletContext().getRequestDispatcher("/shop.jsp");
		view.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
