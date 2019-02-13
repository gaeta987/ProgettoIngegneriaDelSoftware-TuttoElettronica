package it.unisa.control;

import java.io.IOException;

import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import it.unisa.bean.CarrelloBean;
import it.unisa.bean.ProdottoBean;
import it.unisa.bean.ProdottoInMagazzinoBean;
import it.unisa.model.CarrelloManager;
import it.unisa.model.CarrelloManagerDM;
import it.unisa.model.ProdottoManager;
import it.unisa.model.ProdottoManagerDM;

@WebServlet("/PrenotaControl")
public class PrenotaControl extends HttpServlet {
	private static final long serialVersionUID = 1L;
	static ProdottoManager<ProdottoBean> model = new ProdottoManagerDM();
	static CarrelloManager carrelloManager = new CarrelloManagerDM();
       
    public PrenotaControl() {
        super();
    }
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String userRoles =(String)request.getSession().getAttribute("userRoles");
		
		 if(userRoles == null || !userRoles.equalsIgnoreCase("cliente")){
		    	response.sendRedirect("./login.jsp");
				return;
		    }
		 
		String codiceCliente = (String)request.getSession().getAttribute("codiceFiscale");
		CarrelloBean<ProdottoInMagazzinoBean> cart = (CarrelloBean<ProdottoInMagazzinoBean>) request.getSession().getAttribute("cart");;
		
		HttpSession session = request.getSession();
		
		String action = request.getParameter("action");
		
		if(action.equalsIgnoreCase("acquista")) {
			 if(codiceCliente==null) {
				    RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/login.jsp");
					dispatcher.forward(request, response); 
			 }
			/* try {
				request.setAttribute("prod", model.doRetrieveByKey(id).getNome());
			} catch (SQLException e1) {
				e1.printStackTrace();
			}*/
			 
			 try {
				 for(int i = 0; i < cart.getList().size(); i++) {
					 carrelloManager.doPrenota(codiceCliente, cart.getList().get(i));
					 model.doUpdateQuantitaNelCarrello(cart.getList().get(i).getIdProdotto(), 0);
					 cart.deleteElement((ProdottoInMagazzinoBean)(model.doRetrieveByKey(cart.getList().get(i).getIdProdotto(), "prodottoinmagazzino")));
				 }
				 
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		session.setAttribute("cart", cart);
		
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/index.jsp");
		dispatcher.forward(request, response); 
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
