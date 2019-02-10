package it.unisa.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;



public class RecensioneManagerDM implements RecensioneManager<Recensionie> {

	public RecensioneManagerDM() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean doSave(Recensionie recensione) throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		String insertSQL = "INSERT INTO RECENSIONI (CF_CLIENTE,COD_MERCE,TESTO, VOTO) VALUES (?, ?, ?, ?)";

		try {
			connection = DriverManagerConnectionPool.getConnection();
			preparedStatement = connection.prepareStatement(insertSQL);
			preparedStatement.setString(1, recensione.getCodiceCliente());
			preparedStatement.setInt(2, recensione.getCodiceProdotto());
			preparedStatement.setString(3, recensione.getTesto());
			preparedStatement.setInt(4, recensione.getVoto());
			preparedStatement.executeUpdate();
			connection.commit();
			
			return true;
		}catch(Exception e) {return false;} finally {
			try {
				if (preparedStatement != null)
					preparedStatement.close();
			} finally {
				DriverManagerConnectionPool.releaseConnection(connection);
			}
		
	}
	}
	

}
