package it.unisa.control;

import it.unisa.model.*;
import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/CartControl")
public class CartControl extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	static MerceModel<ProdottoBean> model = new MerceModelDM();


    public CartControl() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userRoles =(String)request.getSession().getAttribute("userRoles");
		
		 if(userRoles == null || !userRoles.equalsIgnoreCase("cliente")){
		    	response.sendRedirect("./login.jsp");
				return;
		    }
		 
		String codiceCliente = (String) request.getSession().getAttribute("codiceFiscale");
		int idProdotto = Integer.parseInt(request.getParameter("idProdotto"));
		
		String quantita1 = request.getParameter("quantity");
		int quantita = 0;
		if(quantita1 != null && !quantita1.equalsIgnoreCase(""))
			quantita = Integer.parseInt(quantita1);
		
		Cart<ProdottoInMagazzinoBean> cart = (Cart<ProdottoInMagazzinoBean>) request.getSession().getAttribute("cart");

		HttpSession session = request.getSession();
		synchronized (session) {
			if(cart == null) {
				cart = new Cart<ProdottoInMagazzinoBean>();
				session.setAttribute("cart",cart);
			}
			
			String action = request.getParameter("action");
			
			try {
				 if(action != null) {
					if(action.equalsIgnoreCase("addCart")) {
						 
						 cart.setCodiceFiscaleCliente(codiceCliente);
						 
						 ProdottoInMagazzinoBean prodotto = (ProdottoInMagazzinoBean)(model.doRetrieveByKey(idProdotto, "prodottoinmagazzino"));
						
						 if(cart.getElement(prodotto) != null) {
							 cart.getElement(prodotto).setQuantitaNelCarrello(cart.getElement(prodotto).getQuantitaNelCarrello() + quantita);
							 model.doUpdateQuantitaNelCarrello(prodotto.getIdProdotto(), prodotto.getQuantitaNelCarrello() + quantita);
							 model.doUpdateQuantitaInMagazzino(prodotto.getIdProdotto(), prodotto.getQuantitaInMagazzino() - quantita);
						 }else {
							 prodotto.setQuantitaNelCarrello(quantita);
							 prodotto.setQuantitaInMagazzino(prodotto.getQuantitaInMagazzino() - quantita);
							 cart.addElement(prodotto);
							 model.doUpdateQuantitaNelCarrello(prodotto.getIdProdotto(), prodotto.getQuantitaNelCarrello());
							 model.doUpdateQuantitaInMagazzino(prodotto.getIdProdotto(), prodotto.getQuantitaInMagazzino());
							 
					 } 
				 }else if(action.equalsIgnoreCase("delCart")) {
					 ProdottoInMagazzinoBean prodotto = (ProdottoInMagazzinoBean)model.doRetrieveByKey(idProdotto, "prodottoinmagazzino");
					 cart.deleteElement(prodotto);
				 }
				 }
				 
			} catch(Exception e) {
				System.out.println("Error: "+e.getMessage());
				request.setAttribute("error", e.getMessage());
			}
		}
		
		session.setAttribute("cart", cart);
		
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/cart.jsp");
		dispatcher.forward(request, response);  
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
