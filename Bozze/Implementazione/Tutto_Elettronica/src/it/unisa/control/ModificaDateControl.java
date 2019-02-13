package it.unisa.control;

import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.unisa.model.UserManager;
import it.unisa.model.UserManagerDM;

/**
 * Servlet implementation class ModificaDateControl
 */
@WebServlet("/ModificaDateControl")
public class ModificaDateControl extends HttpServlet {
	private static final long serialVersionUID = 1L;
	static UserManager clienteModel = new UserManagerDM();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ModificaDateControl() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userRoles =(String)request.getSession().getAttribute("userRoles");
	    String codiceFiscale = "CMNGTN80A01C361Z";
	    if(userRoles != null || userRoles.equalsIgnoreCase("gestoreRiparazioni") || userRoles.equals("admin")){
	    	
	    }else{
	    	response.sendRedirect("./login.jsp");
			return;
	    }
	    SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd");
		java.util.Date date = null;
		
	    
	    String data1 = request.getParameter("data1");
	    String data2 = request.getParameter("data2");
	    String data3 = request.getParameter("data3");
	  
	    
	    if(data1 != null && !data1.equalsIgnoreCase("")) {
	    	
			try {
				date = sdf1.parse(data1);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			java.sql.Date nuovaData1 = new java.sql.Date(date.getTime());
			try {
				clienteModel.doUpdateDateGestore(codiceFiscale, nuovaData1, "data1");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	    }
	    
	    if(data2 != null && !data2.equalsIgnoreCase("")) {
	    	
			try {
				date = sdf1.parse(data2);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			java.sql.Date nuovaData2 = new java.sql.Date(date.getTime());
			try {
				clienteModel.doUpdateDateGestore(codiceFiscale, nuovaData2, "data2");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	    }
	    
	    if(data3 != null && !data3.equalsIgnoreCase("")) {
	    	
			try {
				date = sdf1.parse(data3);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			java.sql.Date nuovaData3 = new java.sql.Date(date.getTime());
			try {
				clienteModel.doUpdateDateGestore(codiceFiscale, nuovaData3, "data3");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	    }
	    response.sendRedirect(request.getContextPath() + "/VisualizzaDateControl");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
