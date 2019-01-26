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

import it.unisa.model.AcquistaModel;
import it.unisa.model.AcquistaModelDM;
import it.unisa.model.Cart;
import it.unisa.model.CartModel;
import it.unisa.model.CartModelDM;
import it.unisa.model.MerceModel;
import it.unisa.model.MerceModelDM;
import it.unisa.model.ProdottoBean;
import it.unisa.model.ProdottoInMagazzinoBean;

@WebServlet("/Acquisto")
public class Acquisto extends HttpServlet {
	private static final long serialVersionUID = 1L;
	static MerceModel<ProdottoBean> model = new MerceModelDM();
	static AcquistaModel modelAcquisto = new AcquistaModelDM();
       
    public Acquisto() {
        super();
    }
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String userRoles =(String)request.getSession().getAttribute("userRoles");
		
		 if(userRoles == null || !userRoles.equalsIgnoreCase("cliente")){
		    	response.sendRedirect("./login.jsp");
				return;
		    }
		 
		String codiceCliente = (String)request.getSession().getAttribute("codiceFiscale");
		Cart<ProdottoInMagazzinoBean> cart = (Cart<ProdottoInMagazzinoBean>) request.getSession().getAttribute("cart");;
		
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
					 modelAcquisto.doAcquista(codiceCliente, cart.getList().get(i));
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
