package it.unisa.control;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.unisa.model.ClienteBean;
import it.unisa.model.ClienteModel;
import it.unisa.model.ClienteModelDM;

/**
 * Servlet implementation class VisualizzaAccountControl
 */
@WebServlet("/VisualizzaAccountControl")
public class VisualizzaAccountControl extends HttpServlet {
	private static final long serialVersionUID = 1L;
	static ClienteModel clienteModel = new ClienteModelDM();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public VisualizzaAccountControl() {
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
		 
		String codiceFiscale = (String) request.getSession().getAttribute("codiceFiscale");
		ClienteBean cliente = new ClienteBean();
		try {
			cliente = (ClienteBean)clienteModel.doRetrieveByKey(codiceFiscale);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		request.setAttribute("cliente", cliente);
		
		RequestDispatcher view = getServletContext().getRequestDispatcher("/visualizzaAccountBoundary.jsp");
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
