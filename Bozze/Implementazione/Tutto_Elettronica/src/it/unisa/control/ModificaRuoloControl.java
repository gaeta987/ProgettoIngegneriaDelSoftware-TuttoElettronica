package it.unisa.control;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.unisa.bean.UserBean;
import it.unisa.model.UserManager;
import it.unisa.model.UserManagerDM;

/**
 * Servlet implementation class ModificaRuoloControl
 */
@WebServlet("/ModificaRuoloControl")
public class ModificaRuoloControl extends HttpServlet {
	private static final long serialVersionUID = 1L;
	static UserManager<UserBean> clienteModel = new UserManagerDM();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ModificaRuoloControl() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userRoles =(String)request.getSession().getAttribute("userRoles");
	    
	    
	    if(userRoles == null || !userRoles.equalsIgnoreCase("admin")){
	    	response.sendRedirect("./login.jsp");
			return;
	    }
	    
	    String cf = request.getParameter("cf");
	    String vecchioRuolo = request.getParameter("vecchioRuolo");
	    String ruolo = request.getParameter("ruolo");
	    
	    try {
			clienteModel.doUpdateCliente(clienteModel.doRetrieveByKey(cf), ruolo);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    
	    
	    response.sendRedirect(request.getContextPath() + "/VisualizzaDatiControl");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
