package it.unisa.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;



public class RecensioneModelDM implements RecensioneModel<Recensioni> {

	public RecensioneModelDM() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public Collection<Recensioni> doRetrieveByKey(String codiceCliente) throws SQLException {
		Connection connection=null;
		PreparedStatement preparedStatement=null;
		Collection<Recensioni> recensioni=new ArrayList<Recensioni>();
		
		String selectSQL="SELECT * FROM RECENSIONI WHERE CF_CLIENTE = ?";
		
		try {
			
			connection=DriverManagerConnectionPool.getConnection();
			preparedStatement=connection.prepareStatement(selectSQL);
			preparedStatement.setString(1, codiceCliente);
			ResultSet rs=preparedStatement.executeQuery();
			
			while(rs.next()) {
				Recensioni bean=new Recensioni();
				bean.setCodiceCliente(codiceCliente);
				bean.setCodiceProdotto(rs.getInt("cod_merce"));
				bean.setId(rs.getInt("id"));
				bean.setTesto(rs.getString("testo"));
				bean.setVoto(rs.getInt("voto"));
				
				recensioni.add(bean);
			}
		}finally {
			try {
				if(preparedStatement!=null)
					preparedStatement.close();
			}finally {
				DriverManagerConnectionPool.releaseConnection(connection);
			}
		}
		return recensioni;
	}

	@Override
	public Collection<Recensioni> doRetrieveAll() throws SQLException {
		Connection connection=null;
		PreparedStatement preparedStatement=null;
		Collection<Recensioni> products=new LinkedList<Recensioni>();
		
		String selectSQL="SELECT * FROM RECENSIONI";
		
		try {
			
			connection=DriverManagerConnectionPool.getConnection();
			preparedStatement=connection.prepareStatement(selectSQL);
			
			ResultSet rs=preparedStatement.executeQuery();
			while(rs.next()) {
				Recensioni bean=new Recensioni();
				bean.setId(rs.getInt("id"));
				bean.setVoto(rs.getInt("VOTO"));
				bean.setCodiceProdotto(rs.getInt("COD_MERCE"));
				bean.setCodiceCliente(rs.getString("USERNAME_CLIENTE"));
				bean.setTesto(rs.getString("TESTO"));
				products.add(bean);
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

	@Override
	public void doSave(Recensioni recensione) throws SQLException {
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
		} finally {
			try {
				if (preparedStatement != null)
					preparedStatement.close();
			} finally {
				DriverManagerConnectionPool.releaseConnection(connection);
			}
		
	}
	}

	@Override
	public void doUpdate(Recensioni recensione) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String doRetrieveURL(int code, String user) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean doDelete(int code, String user) throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}

	
	

}
