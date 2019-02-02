package it.unisa.control;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.unisa.model.UserManager;
import it.unisa.model.UserManagerDM;

/**
 * Servlet implementation class ModificaDettagliControl
 */
@WebServlet("/ModificaDettagliControl")
public class ModificaDettagliControl extends HttpServlet {
	private static final long serialVersionUID = 1L;
	static UserManager clienteModel = new UserManagerDM();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ModificaDettagliControl() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userRoles =(String)request.getSession().getAttribute("userRoles");
		
		 if(userRoles == null || !userRoles.equalsIgnoreCase("cliente")){
		    	response.sendRedirect("./login.jsp");
				return;
		    }
		 
		String nuovaMail = request.getParameter("email");
		String nuovaPassword = request.getParameter("password");
		String codiceFiscale = (String)request.getSession().getAttribute("codiceFiscale");
		
		if(nuovaMail != null && !nuovaMail.equalsIgnoreCase("")) {
			try {
				clienteModel.doUpdateEmail(codiceFiscale, nuovaMail);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if(nuovaPassword != null && !nuovaPassword.equalsIgnoreCase("")) {
			try {
				clienteModel.doUpdatePassword(codiceFiscale, nuovaPassword);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		response.sendRedirect(request.getContextPath() + "/VisualizzaAccountControl");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
