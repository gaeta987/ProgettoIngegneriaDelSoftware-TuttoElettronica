package it.unisa.control;

import java.io.IOException;

import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.unisa.model.MerceModel;
import it.unisa.model.MerceModelDM;
import it.unisa.model.ProdottoBean;

@WebServlet("/Categoria")
public class Categoria extends HttpServlet {
	private static final long serialVersionUID = 1L;
      static MerceModel<ProdottoBean> model= new MerceModelDM(); 

    public Categoria() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			request.getSession().setAttribute("prodotti", model.doRetrieveCategoria(request.getParameter("tipo")));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/shop.jsp");
		dispatcher.forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
