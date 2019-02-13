package it.unisa.control;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import it.unisa.bean.UserBean;
import it.unisa.model.UserManager;
import it.unisa.model.UserManagerDM;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class VisualizzaDatiControl
 */
@WebServlet("/VisualizzaDatiControl")
public class VisualizzaDatiControl extends HttpServlet {
	private static final long serialVersionUID = 1L;
	static UserManager<UserBean> clienteModel = new UserManagerDM();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public VisualizzaDatiControl() {
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
	    
	    ArrayList<UserBean> clienti = new ArrayList<UserBean>();
	    try {
			clienti = (ArrayList<UserBean>) clienteModel.doRetrieveAll();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    
	    request.setAttribute("clienti", clienti);
	    
	    RequestDispatcher view = getServletContext().getRequestDispatcher("/visualizzaUtentiBoundary.jsp");
		view.forward(request, response);
	    
	    
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
