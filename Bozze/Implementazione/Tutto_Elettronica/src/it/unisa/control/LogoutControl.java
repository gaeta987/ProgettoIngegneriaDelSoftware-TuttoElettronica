package it.unisa.control;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.unisa.bean.CarrelloBean;
import it.unisa.bean.ProdottoInMagazzinoBean;
import it.unisa.model.CarrelloManager;
import it.unisa.model.CarrelloManagerDM;

@WebServlet("/LogoutControl")
public class LogoutControl extends HttpServlet {
	private static final long serialVersionUID = 1L;
	static CarrelloManager<ProdottoInMagazzinoBean> cartModel = new CarrelloManagerDM();
       
    public LogoutControl() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		CarrelloBean<ProdottoInMagazzinoBean> cart = (CarrelloBean<ProdottoInMagazzinoBean>) request.getSession().getAttribute("cart");
		
		String userRoles = (String)request.getSession().getAttribute("userRoles");
		if(userRoles.equalsIgnoreCase("cliente")) {
			try {
				cartModel.doDeleteProdotti(cart);
				cartModel.doInsertProdotti(cart);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		request.getSession().removeAttribute("userRoles");
		request.getSession().removeAttribute("name");
		request.getSession().removeAttribute("surname");
		request.getSession().removeAttribute("userName"); 
		request.getSession().removeAttribute("codiceFiscale");
		request.getSession().removeAttribute("datePrenotazioni");
		
		
		request.getSession().removeAttribute("cart");
		request.getSession().invalidate();

		String redirectedPage = "/index.jsp";
		response.sendRedirect(request.getContextPath() + redirectedPage);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
