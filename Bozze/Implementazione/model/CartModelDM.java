package it.unisa.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;

public class CartModelDM implements CartModel<ProdottoInMagazzinoBean>{

	static MerceModel<ProdottoBean> model = new MerceModelDM();
	
	@Override
	public Cart<ProdottoInMagazzinoBean> doRetrieveByKey(String codiceCliente) throws SQLException {
		Connection connection=null;
		PreparedStatement preparedStatement=null;
		
		String selectSQL="SELECT * FROM CARRELLO WHERE cf_cliente= ?";
		String[]prodotti;
		ArrayList<ProdottoInMagazzinoBean> prodottiC = new ArrayList<ProdottoInMagazzinoBean>();
		Cart<ProdottoInMagazzinoBean> cart = new Cart<ProdottoInMagazzinoBean>();
		
		try {
			connection=DriverManagerConnectionPool.getConnection();
			preparedStatement=connection.prepareStatement(selectSQL);
			preparedStatement.setString(1, codiceCliente);
			
			ResultSet rs=preparedStatement.executeQuery();
			String prodottiCarrello = "";
			while(rs.next()) {
				cart.setCodiceFiscaleCliente(rs.getString("cf_cliente"));
				cart.setId(rs.getInt("IDCARRELLO"));
				prodottiCarrello = rs.getString("LISTAPRODOTTI");
			}
			
			
			prodotti = prodottiCarrello.split(","); 
			if(!prodottiCarrello.equals("")) {
			   for(int i = 0; i < prodotti.length; i++) {
					int codiceProdotto = Integer.parseInt(prodotti[i]);
					ProdottoInMagazzinoBean prodotto = (ProdottoInMagazzinoBean) model.doRetrieveByKey(codiceProdotto, "prodottoinmagazzino");
					prodottiC.add(prodotto);
				}
				cart.setList(prodottiC);
			}
			
			
		}finally {
			try {
				if(preparedStatement!=null)
					preparedStatement.close();
			}finally {
				DriverManagerConnectionPool.releaseConnection(connection);
			}
		}
		return cart;
	}
	
	
	public void doInsertProdotti(Cart carrello) throws SQLException{
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		
		String insertSQL = "INSERT INTO CARRELLO (CF_CLIENTE, LISTAPRODOTTI) VALUES (?, ?)";
		
		
		String listaProdotti = "";
		ArrayList<ProdottoInMagazzinoBean> lista = (ArrayList<ProdottoInMagazzinoBean>) carrello.getList();
		
		for(int i = 0; i < lista.size(); i++) {
			listaProdotti += lista.get(i).getIdProdotto() + ",";
		}
		try {
			
			connection=DriverManagerConnectionPool.getConnection();
			preparedStatement=connection.prepareStatement(insertSQL);
			preparedStatement.setString(1, carrello.getCodiceFiscaleCliente());
			preparedStatement.setString(2, listaProdotti);
			
		    preparedStatement.executeUpdate();
			
			connection.commit();
			
			
		}finally {
			try {
				if(preparedStatement!=null)
					preparedStatement.close();
			}finally {
				DriverManagerConnectionPool.releaseConnection(connection);
			}
		}
	}
	
	public void doDeleteProdotti(Cart carrello) throws SQLException{
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		
		String deleteSQL = "DELETE FROM carrello WHERE idCarrello = ?";
		
		try {
			connection = DriverManagerConnectionPool.getConnection();
			preparedStatement = connection.prepareStatement(deleteSQL);
			preparedStatement.setInt(1, carrello.getId());
			preparedStatement.executeUpdate();

			connection.commit();
		} finally {
			try {
				if (preparedStatement != null)
					preparedStatement.close();
			} finally {
				DriverManagerConnectionPool.releaseConnection(connection);
			}
		}
	}

}
