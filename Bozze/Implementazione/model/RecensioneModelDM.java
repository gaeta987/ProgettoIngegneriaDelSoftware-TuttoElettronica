package it.unisa.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;
import java.util.LinkedList;



public class RecensioneModelDM implements RecensioneModel<Recensioni> {

	public RecensioneModelDM() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public Collection<Recensioni> doRetrieveByKey(int code) throws SQLException {
		Connection connection=null;
		PreparedStatement preparedStatement=null;
		Collection<Recensioni> products=new LinkedList<Recensioni>();
		
		String selectSQL="SELECT * FROM RECENSIONI WHERE COD_MERCE = ?";
		
		try {
			
			connection=DriverManagerConnectionPool.getConnection();
			preparedStatement=connection.prepareStatement(selectSQL);
			preparedStatement.setInt(1, code);
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

		String insertSQL = "INSERT INTO RECENSIONI (ID,CFCLIENTE,COD_MERCE,TESTO, VOTO) VALUES (?, ?, ?, ?, ?)";

		try {
			connection = DriverManagerConnectionPool.getConnection();
			preparedStatement = connection.prepareStatement(insertSQL);
			preparedStatement.setInt(1, recensione.getId());
			preparedStatement.setString(2, recensione.getCodiceCliente());
			preparedStatement.setInt(3, recensione.getCodiceProdotto());
			preparedStatement.setString(4, recensione.getTesto());
			preparedStatement.setInt(5, recensione.getVoto());
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
