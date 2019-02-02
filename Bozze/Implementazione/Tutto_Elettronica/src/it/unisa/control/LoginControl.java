package it.unisa.control;

import java.io.IOException;
import java.sql.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.unisa.model.Carrello;
import it.unisa.model.CarrelloManager;
import it.unisa.model.CarrelloManagerDM;
import it.unisa.model.UserBean;
import it.unisa.model.UserManager;
import it.unisa.model.UserManagerDM;
import it.unisa.model.ProdottoInMagazzinoBean;
import it.unisa.model.RiparazioneManagerDM;

@WebServlet("/LoginControl")
public class LoginControl extends HttpServlet {
	static UserManager<UserBean> model=new UserManagerDM();
	static CarrelloManager<ProdottoInMagazzinoBean> cartModel = new CarrelloManagerDM();
	static RiparazioneManagerDM riparazioneModel = new RiparazioneManagerDM();
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
			String username = request.getParameter("username");
			String password = request.getParameter("password");
			
			String redirectedPage;
			try {
				String regola=checkLogin(username, password,request,response);
				if(regola.equals("admin")) {
				request.getSession().setAttribute("userRoles", "admin");
				redirectedPage = "/index.jsp";
				}
				else 
					if(regola.equals("gestoreProdotti")){
						request.getSession().setAttribute("userRoles", "gestoreProdotti");
						redirectedPage = "/index.jsp";
				}else
					if(regola.equals("gestoreRiparazioni")) {
						request.getSession().setAttribute("userRoles", "gestoreRiparazioni");
						redirectedPage = "/index.jsp";
					}
					else {
						request.getSession().setAttribute("userRoles", "cliente");
						redirectedPage = "/index.jsp";
						
						Carrello<ProdottoInMagazzinoBean> cart;
						cart = cartModel.doRetrieveByKey((String)request.getSession().getAttribute("codiceFiscale"));
						request.getSession().setAttribute("cart", cart);
					
						Date[] date = riparazioneModel.doRetrieveAll();
						request.getSession().setAttribute("datePrenotazioni", date);
						
					}
			} catch (Exception e) {
				request.getSession().setAttribute("userRoles", "navigatore");
				redirectedPage = "/login.jsp";
			}
			response.sendRedirect(request.getContextPath() + redirectedPage);
		
	}

	private String checkLogin(String username, String password,HttpServletRequest request, HttpServletResponse response) throws Exception {
		UserBean cliente=model.doRetrieveUtente(username, password);
		if (cliente.getUsername().equals(username)) {
			request.getSession().setAttribute("name",cliente.getNome());
			request.getSession().setAttribute("surname",cliente.getCognome());
			request.getSession().setAttribute("userName",cliente.getUsername());
			request.getSession().setAttribute("codiceFiscale", cliente.getCf());
			return cliente.getRuolo();
		} else
			throw new Exception("Invalid login and password");
	}
	
	private static final long serialVersionUID = 1L;

	public LoginControl() {
		super();
	}	

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}
	

}
