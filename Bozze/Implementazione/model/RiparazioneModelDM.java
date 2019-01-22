package it.unisa.model;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;

public class RiparazioneModelDM implements RiparazioneModel{

	@Override
	public void doSave(Date data) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void doUpdate(Date data) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void doUpdateRiparazione(ProdottoInRiparazioneBean prodotto) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Date[] doRetrieveAll() throws SQLException {
		Connection connection=null;
		PreparedStatement preparedStatement=null;
		
		Date[] date =new Date[3] ;
		
		String retrieveSQL1 = "SELECT * FROM gestoreRiparazioni";
		
		try {
			connection=DriverManagerConnectionPool.getConnection();
			preparedStatement=connection.prepareStatement(retrieveSQL1);
			
			ResultSet rs=preparedStatement.executeQuery();
			
			while(rs.next()) {
				date[0] = rs.getDate("data1");
				date[1] = rs.getDate("data2");
				date[2] = rs.getDate("data3");
			}
			
		}catch(Exception e){
			try {
				if(preparedStatement!=null)
					preparedStatement.close();
			}finally {
				DriverManagerConnectionPool.releaseConnection(connection);
			}
		}
		return date;
	}

	@Override
	public void doSaveRiparazione(ProdottoBean prodotto, Date data, String codiceCliente) throws SQLException {
		Connection connection=null;
		PreparedStatement preparedStatement2 = null;
		
		String insertSQL1 = "INSERT INTO PRODOTTOINRIPARAZIONE (IDPR, DATAINCONTRO, CFCLIENTE, STATORIPARAZIONE, DESCRIZIONEPROBLEMA) VALUES (?,?,?,?,?)";
		
		try {
			connection = DriverManagerConnectionPool.getConnection();
			preparedStatement2 = connection.prepareStatement(insertSQL1);
			preparedStatement2.setInt(1, prodotto.getIdProdotto());
			preparedStatement2.setDate(2, data);
			preparedStatement2.setString(3, codiceCliente);
			preparedStatement2.setString(4, "non riparato");
			preparedStatement2.setString(5, prodotto.getDescrizione());
			preparedStatement2.executeUpdate();
			
			connection.commit();
		}catch(Exception e){
			try {
				if(preparedStatement2!=null)
					preparedStatement2.close();
			}finally {
				DriverManagerConnectionPool.releaseConnection(connection);
			}
		}
		
	}

}
