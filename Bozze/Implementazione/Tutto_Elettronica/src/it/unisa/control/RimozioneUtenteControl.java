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
 * Servlet implementation class RimozioneUtenteControl
 */
@WebServlet("/RimozioneUtenteControl")
public class RimozioneUtenteControl extends HttpServlet {
	private static final long serialVersionUID = 1L;
	static UserManager<UserBean> clienteModel = new UserManagerDM();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RimozioneUtenteControl() {
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
	    String cfUtente = request.getParameter("cfUtente");
	    
	    try {
			clienteModel.doDelete(cfUtente);
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
