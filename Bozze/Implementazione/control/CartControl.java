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
	static CartModel<ProdottoInMagazzinoBean> cartModel = new CartModelDM();

    public CartControl() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
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
						 String codiceCliente = (String) request.getSession().getAttribute("codiceFiscale");
						 cart = cartModel.doRetrieveByKey(codiceCliente);
						 cart.setCodiceFiscaleCliente(codiceCliente);
						 
						 cart.addElement((ProdottoInMagazzinoBean)(model.doRetrieveByKey(idProdotto, "prodottoinmagazzino")));
						 
						 if(cart.getList().size() == 1)
							 cartModel.doInsertProdotti(cart);
						 else
							 cartModel.doUpdateProdotti(cart);
					 } else if(action.equalsIgnoreCase("delCart")) {/*
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
