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
		
		String codiceCliente = (String) request.getSession().getAttribute("codiceFiscale");
		
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
						 int idProdotto = Integer.parseInt(request.getParameter("idProdotto"));
						 int quantita = Integer.parseInt(request.getParameter("quantity"));
						 
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
				 }else if(action.equalsIgnoreCase("delCart")) {/*
					 int id = Integer.parseInt(request.getParameter("id"));
					 cart.deleteElement(model.doRetrieveByKey(id));*/
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
