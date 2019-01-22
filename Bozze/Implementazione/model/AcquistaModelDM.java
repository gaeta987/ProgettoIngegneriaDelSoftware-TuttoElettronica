package it.unisa.model;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;


public class AcquistaModelDM implements AcquistaModel {

	public void doAcquista(String codiceCliente, ProdottoInMagazzinoBean prodotto) throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		String insertSQL = "INSERT INTO PRODOTTOPRENOTATO (IDP, CFCLIENTE, DATAPRENOTAZIONE, QUANTITAPRENOTATA) VALUES (?, ?, ?, ?)";

		try {
			connection = DriverManagerConnectionPool.getConnection();
			preparedStatement = connection.prepareStatement(insertSQL);
			preparedStatement.setString(2, codiceCliente);
			preparedStatement.setInt(1, prodotto.getIdProdotto());
			preparedStatement.setDate(3, new Date(System.currentTimeMillis()));
			preparedStatement.setInt(4, prodotto.getQuantitaNelCarrello());
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

	public ArrayList<Integer> doRetrieveAllCode(String codiceCliente) throws SQLException {
		Connection connection=null;
		PreparedStatement preparedStatement=null;
		ArrayList<Integer> products = new ArrayList<Integer>();
		
		String selectSQL="SELECT idpm FROM prodottoPrenotato WHERE cfcliente = ?";
		
		try {
			
			connection=DriverManagerConnectionPool.getConnection();
			preparedStatement=connection.prepareStatement(selectSQL);
			preparedStatement.setString(1, codiceCliente);
			
			ResultSet rs=preparedStatement.executeQuery();
			while(rs.next()) {
				products.add(rs.getInt("idpm"));	
			}
		}finally {
			try {
				if(preparedStatement!=null)
					preparedStatement.close();
			}finally {
				DriverManagerConnectionPool.releaseConnection(connection);
			}
		}
		
		return products;
	}

	public void doElimina(int code) throws SQLException {
	/*	Connection connection = null;
		PreparedStatement preparedStatement = null;

		String insertSQL = "DELETE FROM ACQUISTA WHERE COD_MERCE = ?";

		try {
			connection = DriverManagerConnectionPool.getConnection();
			preparedStatement = connection.prepareStatement(insertSQL);
			preparedStatement.setInt(1, code);
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
		*/
	}

	
	

}
