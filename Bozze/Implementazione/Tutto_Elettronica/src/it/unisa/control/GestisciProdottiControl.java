package it.unisa.control;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.unisa.model.ProdottoManager;
import it.unisa.model.ProdottoManagerDM;
import it.unisa.model.ProdottoBean;

/**
 * Servlet implementation class GestisciProdottiControl
 */
@WebServlet("/GestisciProdottiControl")
public class GestisciProdottiControl extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	static ProdottoManager merceModel = new ProdottoManagerDM();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GestisciProdottiControl() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 String userRoles =(String)request.getSession().getAttribute("userRoles");
		   
		    
		 if(userRoles != null || userRoles.equalsIgnoreCase("gestoreProdotti") || userRoles.equals("admin")){
		    	
		    }else{
		    	response.sendRedirect("./login.jsp");
				return;
		    }
	    String action = request.getParameter("action");
	    String redirectPage= "";
	    
	    if(action.equalsIgnoreCase("delete")) {
			try {
				merceModel.doDelete(Integer.parseInt(request.getParameter("id")));
			} catch (NumberFormatException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			redirectPage = "/VisualizzaProdottiControl";
	    }else
	    	if(action.equalsIgnoreCase("modifica")) {
	    		String quantita = request.getParameter("quantita");
	    		int id = Integer.parseInt(request.getParameter("id"));
	    		String prezzo = request.getParameter("prezzo");
	    		
	    		if(quantita != null && !quantita.equalsIgnoreCase("")) {
		    		try {
						merceModel.doUpdateQuantitaInMagazzino(id, Integer.parseInt(quantita));
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
	    		}
	    		if(prezzo != null && !prezzo.equalsIgnoreCase("")) {
	    			try {
						merceModel.doUpdatePrezzo(id, Double.parseDouble(prezzo));
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
	    		}
	    		redirectPage = "/VisualizzaProdottiControl";
	    		
	    	}else
	    		if(action.equalsIgnoreCase("addProdotto")) {
	    				String nome = request.getParameter("nome");
	    			    String categoria = request.getParameter("categoria");
	    			    String marca = request.getParameter("marca");
	    			    double prezzo = Double.parseDouble(request.getParameter("prezzo"));
	    			    String descrizione = request.getParameter("descrizione");
	    			    boolean promo = Boolean.parseBoolean(request.getParameter("promo"));
	    			    int quantit‡Magazzino = Integer.parseInt(request.getParameter("quantitaMagazzino"));
	    			    String immagine = request.getParameter("immagine");
	    			    
	    			    
	    			    ProdottoBean prodotto = new ProdottoBean();
	    			    prodotto.setNome(nome);
	    			    prodotto.setTipo(categoria);
	    			    prodotto.setMarca(marca);
	    			    prodotto.setCosto(prezzo);
	    			    prodotto.setDescrizione(descrizione);
	    			    prodotto.setImmagine(immagine);
	    			   
	    			    try {
	    			    	merceModel.doSave(prodotto);
	    			    	prodotto.setIdProdotto(merceModel.doRetrieveLastKey());
	    					merceModel.doSaveInMagazzino(prodotto, promo, quantit‡Magazzino);
	    				} catch (SQLException e) {
	    					// TODO Auto-generated catch block
	    					e.printStackTrace();
	    				}
	    			    
	    			    redirectPage = "/aggiungiImmagine.jsp";
	    		}
		   
		   response.sendRedirect(request.getContextPath() + redirectPage);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
