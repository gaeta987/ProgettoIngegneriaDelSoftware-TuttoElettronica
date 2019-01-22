package it.unisa.control;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.unisa.model.Cart;
import it.unisa.model.CartModel;
import it.unisa.model.CartModelDM;
import it.unisa.model.ProdottoInMagazzinoBean;

@WebServlet("/Logout")
public class Logout extends HttpServlet {
	private static final long serialVersionUID = 1L;
	static CartModel<ProdottoInMagazzinoBean> cartModel = new CartModelDM();
       
    public Logout() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Cart<ProdottoInMagazzinoBean> cart = (Cart<ProdottoInMagazzinoBean>) request.getSession().getAttribute("cart");;;
		request.getSession().removeAttribute("userRoles");
		request.getSession().removeAttribute("name");
		request.getSession().removeAttribute("surname");
		request.getSession().removeAttribute("userName"); 
		request.getSession().removeAttribute("codiceFiscale");
		request.getSession().removeAttribute("datePrenotazioni");
		
		try {
			cartModel.doDeleteProdotti(cart);
			cartModel.doInsertProdotti(cart);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		request.getSession().removeAttribute("cart");
		request.getSession().invalidate();

		String redirectedPage = "/index.jsp";
		response.sendRedirect(request.getContextPath() + redirectedPage);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
