package it.unisa.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;
import java.util.LinkedList;

import it.unisa.model.DriverManagerConnectionPool;

public class ClienteModelDM implements ClienteModel<ClienteBean> {

	public ClienteModelDM() {
		
	}

	

	@Override
	public Collection<ClienteBean> doRetrieveAll() throws SQLException {
		Connection connection=null;
		PreparedStatement preparedStatement=null;
		
		Collection<ClienteBean> products=new LinkedList<ClienteBean>();
		String selectSQL="SELECT USERNAME, NOME, COGNOME, RUOLO FROM CLIENTE WHERE RUOLO=?";
		
		try {
			connection=DriverManagerConnectionPool.getConnection();
			preparedStatement=connection.prepareStatement(selectSQL);
			preparedStatement.setString(1, "cliente");
			
			ResultSet rs=preparedStatement.executeQuery();
			while(rs.next()) {
				ClienteBean bean=new ClienteBean();
				
				bean.setUsername(rs.getString("USERNAME"));
				bean.setCognome(rs.getString("COGNOME"));
				bean.setNome(rs.getString("NOME"));
				bean.setRuolo(rs.getString("RUOLO"));
				
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
		
		return  products;
	}

	@Override
	public void doSave(ClienteBean cliente) throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		String insertSQL = "INSERT INTO CLIENTE" 
				+ " (USERNAME, INDIRIZZO, CF, NOME, COGNOME, RUOLO, PASSWORD, EMAIL) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

		try {
			
			connection = DriverManagerConnectionPool.getConnection();
			preparedStatement = connection.prepareStatement(insertSQL);
			preparedStatement.setString(1, cliente.getUsername() );
			preparedStatement.setString(2, cliente.getIndirizzo());
			preparedStatement.setString(3, cliente.getCf());
			preparedStatement.setString(4, cliente.getNome());
			preparedStatement.setString(5, cliente.getCognome());
			preparedStatement.setString(6, cliente.getRuolo());
			preparedStatement.setString(7, cliente.getPassword());
			preparedStatement.setString(8, cliente.getEmail());
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
	public void doUpdate(ClienteBean product) throws SQLException {
		// TODO Auto-generated method stub
		
	}



	@Override
	public ClienteBean doRetrieveUtente(String username, String Password) throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs=null;
		ClienteBean bean=new ClienteBean();
		String insertSQL = "SELECT USERNAME, RUOLO, NOME, COGNOME, CF FROM CLIENTE WHERE USERNAME=?&&PASSWORD=?" ;
				

		try {
			
			con = DriverManagerConnectionPool.getConnection();
			ps = con.prepareStatement(insertSQL);
			ps.setString(1, username );
			ps.setString(2, Password);
			rs=ps.executeQuery();
			while (rs.next()) {
				bean.setUsername(rs.getString("USERNAME"));
				bean.setRuolo(rs.getString("RUOLO"));
				bean.setNome(rs.getString("NOME"));
				bean.setCognome(rs.getString("COGNOME"));
				bean.setCf(rs.getString("CF"));
			}
			
		} finally {
			try {
				if (ps != null)
					ps.close();
			} finally {
				DriverManagerConnectionPool.releaseConnection(con);
			}
		}
		return bean;
	}



	@Override
	public void doUpdateAdmin(String user) throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		String insertSQL = "UPDATE CLIENTE SET RUOLO = ? WHERE USERNAME = ?";

		try {
			
			connection = DriverManagerConnectionPool.getConnection();
			preparedStatement = connection.prepareStatement(insertSQL);
			preparedStatement.setString(1, "admin");
			preparedStatement.setString(2, user);
			
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
	public void doUpdateRuolo(String user) throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		String insertSQL = "UPDATE CLIENTE SET RUOLO = ? WHERE USERNAME = ?";

		try {
			
			connection = DriverManagerConnectionPool.getConnection();
			preparedStatement = connection.prepareStatement(insertSQL);
			preparedStatement.setString(1, "cliente");
			preparedStatement.setString(2, user);
			
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
	public Collection<ClienteBean> doRetrieveAll2() throws SQLException {
		Connection connection=null;
		PreparedStatement preparedStatement=null;
		
		Collection<ClienteBean> products=new LinkedList<ClienteBean>();
		String selectSQL="SELECT USERNAME, NOME, COGNOME, RUOLO FROM CLIENTE WHERE RUOLO=?";
		
		try {
			connection=DriverManagerConnectionPool.getConnection();
			preparedStatement=connection.prepareStatement(selectSQL);
			preparedStatement.setString(1, "admin");
			
			ResultSet rs=preparedStatement.executeQuery();
			while(rs.next()) {
				ClienteBean bean=new ClienteBean();
				
				bean.setUsername(rs.getString("USERNAME"));
				bean.setCognome(rs.getString("COGNOME"));
				bean.setNome(rs.getString("NOME"));
				bean.setRuolo(rs.getString("RUOLO"));
				
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
		
		return  products;
	}



	@Override
	public boolean doDelete(String user) throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		int result = 0;

		String deleteSQL = "DELETE FROM CLIENTE WHERE USERNAME = ?";

		try {
			connection = DriverManagerConnectionPool.getConnection();
			preparedStatement = connection.prepareStatement(deleteSQL);
			preparedStatement.setString(1, user);
			result = preparedStatement.executeUpdate();

			connection.commit();
		} finally {
			try {
				if (preparedStatement != null)
					preparedStatement.close();
			} finally {
				DriverManagerConnectionPool.releaseConnection(connection);
			}
		}
		return (result != 0);
	}



	@Override
	public void doUpdatePassword(String user, String pass) throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		String insertSQL = "UPDATE CLIENTE SET PASSWORD = ? WHERE USERNAME = ?";

		try {
			
			connection = DriverManagerConnectionPool.getConnection();
			preparedStatement = connection.prepareStatement(insertSQL);
			preparedStatement.setString(1, pass);
			preparedStatement.setString(2, user);
			
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









	

