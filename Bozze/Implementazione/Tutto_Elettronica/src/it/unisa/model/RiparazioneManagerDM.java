package it.unisa.model;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;

public class RiparazioneManagerDM implements RiparazioneManager{


	@Override
	public boolean doUpdateStato(String stato, int idRiparazione) throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		String insertSQL = "UPDATE PRODOTTOINRIPARAZIONE SET statoriparazione = ? WHERE idprenotazioneriparazione = ?";
		
		try {
			
			connection = DriverManagerConnectionPool.getConnection();
			preparedStatement = connection.prepareStatement(insertSQL);
			preparedStatement.setString(1, stato);
			preparedStatement.setInt(2, idRiparazione);
			
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
	
	@Override
	public boolean doUpdateData(Date data, int idPrenotazione) throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		String insertSQL = "UPDATE PRODOTTOINRIPARAZIONE SET DATAFINELAVORO = ? WHERE idprenotazioneriparazione = ?";
		
		try {
			
			connection = DriverManagerConnectionPool.getConnection();
			preparedStatement = connection.prepareStatement(insertSQL);
			preparedStatement.setDate(1, data);
			preparedStatement.setInt(2, idPrenotazione);
			
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
		
		String insertSQL1 = "INSERT INTO PRODOTTOINRIPARAZIONE (IDPR, DATAINCONTRO, CFCLIENTE, STATORIPARAZIONE, DESCRIZIONEPROBLEMA, DATAFINELAVORO, CATEGORIA) VALUES (?,?,?,?,?,?,?)";
		
		try {
			connection = DriverManagerConnectionPool.getConnection();
			preparedStatement2 = connection.prepareStatement(insertSQL1);
			preparedStatement2.setInt(1, prodotto.getIdProdotto());
			preparedStatement2.setDate(2, data);
			preparedStatement2.setString(3, codiceCliente);
			preparedStatement2.setString(4, "non riparato");
			preparedStatement2.setString(5, prodotto.getDescrizione());
			preparedStatement2.setDate(6, null);
			preparedStatement2.setString(7, prodotto.getTipo());
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

	@Override
	public Collection<ProdottoInRiparazioneBean> doRetrieveAllRiparazioni() throws SQLException {
		Connection connection=null;
		PreparedStatement preparedStatement = null;
		
		String selectSQL1 = "SELECT * FROM PRODOTTOINRIPARAZIONE";
		
		Collection<ProdottoInRiparazioneBean> prodotti = new ArrayList<ProdottoInRiparazioneBean>();
		
		try {
			connection=DriverManagerConnectionPool.getConnection();
			preparedStatement=connection.prepareStatement(selectSQL1);
			
			ResultSet rs=preparedStatement.executeQuery();
			
			while(rs.next()) {
				ProdottoInRiparazioneBean bean = new ProdottoInRiparazioneBean();
				bean.setCodiceCliente(rs.getString("CFCLIENTE"));
				bean.setIdProdotto(rs.getInt("IDPR"));
				bean.setStatoRiparazione(rs.getString("STATORIPARAZIONE"));
				bean.setDescrizioneProblema(rs.getString("DESCRIZIONEPROBLEMA"));
				bean.setDataIncontro(rs.getDate("DATAINCONTRO"));
				bean.setDataFineLavoro(rs.getDate("DATAFINELAVORO"));
				bean.setIdPrenotazione(rs.getInt("idPrenotazioneRiparazione"));
				prodotti.add(bean);
			}
			
		}catch(Exception e){
			try {
				if(preparedStatement!=null)
					preparedStatement.close();
			}finally {
				DriverManagerConnectionPool.releaseConnection(connection);
			}
		}
		return prodotti;

	}


	
	
}
