package it.unisa.control;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.unisa.model.UserBean;
import it.unisa.model.UserManager;
import it.unisa.model.UserManagerDM;

/**
 * Servlet implementation class RegistrazioneControl
 */
@WebServlet("/RegistrazioneControl")
public class RegistrazioneControl extends HttpServlet {
	private static final long serialVersionUID = 1L;
	static UserManager<UserBean> clienteModel = new UserManagerDM();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegistrazioneControl() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("username");
		String nome = request.getParameter("nome");
		String cognome = request.getParameter("cognome");
		String password = request.getParameter("password");
		String cf = request.getParameter("cf");
		String email = request.getParameter("email");
		String indirizzo = request.getParameter("indirizzo");
		
		UserBean cliente = new UserBean();
		cliente.setCf(cf);
		cliente.setCognome(cognome);
		cliente.setEmail(email);
		cliente.setIndirizzo(indirizzo);
		cliente.setNome(nome);
		cliente.setPassword(password);
		cliente.setRuolo("cliente");
		cliente.setUsername(username);
		
		try {
			clienteModel.doSave(cliente);
			clienteModel.doSaveClienteRegistrato(cliente);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		response.sendRedirect(request.getContextPath() + "/index.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
