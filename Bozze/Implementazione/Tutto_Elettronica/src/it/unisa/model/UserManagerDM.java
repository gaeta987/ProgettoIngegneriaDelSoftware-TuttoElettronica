package it.unisa.model;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;

import it.unisa.bean.ProdottoBean;
import it.unisa.bean.ProdottoInRiparazioneBean;
import it.unisa.bean.ProdottoPrenotatoBean;
import it.unisa.bean.UserBean;
import it.unisa.model.DriverManagerConnectionPool;

public class UserManagerDM implements UserManager<UserBean> {

	public UserManagerDM() {
		
	}

	@Override
	public UserBean doRetrieveByKey(String codiceFiscale) throws SQLException{
		Connection connection=null;
		PreparedStatement preparedStatement=null;
		
		UserBean bean = new UserBean();
		
		String selectSQL = "SELECT * FROM CLIENTE WHERE CF = ? && RUOLO = ?";
		String cript = "";
		try {
			connection=DriverManagerConnectionPool.getConnection();
			preparedStatement=connection.prepareStatement(selectSQL);
			preparedStatement.setString(1, codiceFiscale);
			preparedStatement.setString(2, "cliente");
			
			ResultSet rs=preparedStatement.executeQuery();
			while(rs.next()) {
				bean.setUsername(rs.getString("USERNAME"));
				bean.setCognome(rs.getString("COGNOME"));
				bean.setNome(rs.getString("NOME"));
				bean.setRuolo(rs.getString("RUOLO"));
				bean.setIndirizzo(rs.getString("INDIRIZZO"));
				bean.setCf(rs.getString("CF"));
				bean.setEmail(rs.getString("EMAIL"));
				cript = rs.getString("PASSWORD");
				bean.setPassword(MyCript.decrypt(cript));
			}
		}finally {
			try {
				if(preparedStatement!=null)
					preparedStatement.close();
			}finally {
				DriverManagerConnectionPool.releaseConnection(connection);
			}
		}
		return bean;
		
	}
	

	@Override
	public Collection<UserBean> doRetrieveAll() throws SQLException {
		Connection connection=null;
		PreparedStatement preparedStatement=null;
		
		Collection<UserBean> products=new ArrayList<UserBean>();
		String selectSQL="SELECT USERNAME, NOME, COGNOME, RUOLO, CF FROM CLIENTE";
		
		try {
			connection=DriverManagerConnectionPool.getConnection();
			preparedStatement=connection.prepareStatement(selectSQL);
			
			ResultSet rs=preparedStatement.executeQuery();
			while(rs.next()) {
				UserBean bean=new UserBean();
				
				bean.setUsername(rs.getString("USERNAME"));
				bean.setCognome(rs.getString("COGNOME"));
				bean.setNome(rs.getString("NOME"));
				bean.setRuolo(rs.getString("RUOLO"));
				bean.setCf(rs.getString("CF"));
				
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
	public boolean doSave(UserBean cliente) throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		String insertSQL = "INSERT INTO CLIENTE" 
				+ " (USERNAME, INDIRIZZO, CF, NOME, COGNOME, RUOLO, PASSWORD, EMAIL) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
		
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
			
			return true;
		}catch(Exception e) {return false;} finally {
			try {
				if (preparedStatement != null) {
					preparedStatement.close();
				}
			} finally {
				DriverManagerConnectionPool.releaseConnection(connection);
			}
		}
		
	}

	public boolean doSaveClienteRegistrato(UserBean cliente) throws SQLException{
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		
		String insertSQL1 = "INSERT INTO CLIENTEREGISTRATO (CFCLIENTEREGISTRATO) VALUES (?)";
		
		try {
			
			connection = DriverManagerConnectionPool.getConnection();
			preparedStatement = connection.prepareStatement(insertSQL1);
			
			preparedStatement = connection.prepareStatement(insertSQL1);
			preparedStatement.setString(1, cliente.getCf());
			preparedStatement.executeUpdate();
			
			connection.commit();
			
			return true;
		}catch(Exception e) {return false;} finally {
			try {
				if (preparedStatement != null) {
					preparedStatement.close();
				}
			} finally {
				DriverManagerConnectionPool.releaseConnection(connection);
			}
		}
		
	}

	@Override
	public UserBean doRetrieveUtente(String username, String password) throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs=null;
		UserBean bean=new UserBean();
		
		String cript = MyCript.encrypt(password);
		
		String insertSQL = "SELECT USERNAME, RUOLO, NOME, COGNOME, CF FROM CLIENTE WHERE USERNAME=?&&PASSWORD=?" ;
				
		
		try {
			
			con = DriverManagerConnectionPool.getConnection();
			ps = con.prepareStatement(insertSQL);
			ps.setString(1, username );
			ps.setString(2, cript);
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

	public Collection<ProdottoBean> doRetrieveByCodiceFiscale(String codiceFiscale, String tipoProdotto) throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		String selectSQL = "";
		ArrayList<ProdottoBean> prodotti = new ArrayList<ProdottoBean>();
		
		if(tipoProdotto.equalsIgnoreCase("prodottoprenotato")) {
			selectSQL="SELECT * FROM PRODOTTOPRENOTATO AS PP, PRODOTTO AS P WHERE PP.CFCLIENTE = ? && P.CODICE = PP.IDP";
			try {
				
				connection=DriverManagerConnectionPool.getConnection();
				preparedStatement=connection.prepareStatement(selectSQL);
				preparedStatement.setString(1, codiceFiscale);
				ResultSet rs=preparedStatement.executeQuery();
				while(rs.next()) {
					ProdottoPrenotatoBean bean=new ProdottoPrenotatoBean();
					bean.setIdProdotto(rs.getInt("idp"));
					bean.setCodiceCliente(rs.getString("cfcliente"));
					bean.setDataPrenotazione(rs.getDate("dataprenotazione"));
					bean.setQuantitaPrenotata(rs.getInt("quantitaprenotata"));
					bean.setNome(rs.getString("nome"));
					bean.setTipo(rs.getString("categoria"));
					bean.setCosto(rs.getDouble("prezzo"));
					bean.setImmagine(rs.getString("immagine"));
					prodotti.add(bean);
				}
			}finally {
				try {
					if(preparedStatement!=null)
						preparedStatement.close();
				}finally {
					DriverManagerConnectionPool.releaseConnection(connection);
				}
			}
			
		}else
			if(tipoProdotto.equalsIgnoreCase("prodottoinriparazione")) {
				selectSQL="SELECT * FROM PRODOTTOINRIPARAZIONE AS PR, PRODOTTO AS P WHERE PR.CFCLIENTE = ? && P.CODICE = PR.IDPR";
				try {
					
					connection=DriverManagerConnectionPool.getConnection();
					preparedStatement=connection.prepareStatement(selectSQL);
					preparedStatement.setString(1, codiceFiscale);
					ResultSet rs=preparedStatement.executeQuery();
					while(rs.next()) {
						ProdottoInRiparazioneBean bean=new ProdottoInRiparazioneBean();
						bean.setIdProdotto(rs.getInt("idpr"));
						bean.setCodiceCliente(rs.getString("cfcliente"));
						bean.setDataIncontro(rs.getDate("dataincontro"));
						bean.setStatoRiparazione(rs.getString("statoriparazione"));
						bean.setDescrizioneProblema(rs.getString("descrizioneproblema"));
						bean.setNome(rs.getString("nome"));
						bean.setTipo(rs.getString("categoria"));
						bean.setImmagine(rs.getString("immagine"));
						prodotti.add(bean);
					}
				}finally {
					try {
						if(preparedStatement!=null)
							preparedStatement.close();
					}finally {
						DriverManagerConnectionPool.releaseConnection(connection);
					}
				}
			}
		
		return prodotti;
		
	}


	@Override
	public boolean doDelete(String cf) throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		PreparedStatement preparedStatement2 = null;


		String deleteSQL = "DELETE FROM CLIENTE WHERE cf = ?";
		String deleteSQL1 = "DELETE FROM CLIENTEREGISTRATO WHERE CFCLIENTEREGISTRATO = ?";

		try {
			connection = DriverManagerConnectionPool.getConnection();
			
			preparedStatement2 = connection.prepareStatement(deleteSQL1);
			preparedStatement2.setString(1, cf);
			preparedStatement2.executeUpdate();
			
			preparedStatement = connection.prepareStatement(deleteSQL);
			preparedStatement.setString(1, cf);
			preparedStatement.executeUpdate();

			connection.commit();
			
			return true;
		}catch(Exception e) { return false;}
				finally {
			try {
				if (preparedStatement2 != null)
					preparedStatement2.close();
			} finally {
				DriverManagerConnectionPool.releaseConnection(connection);
			}
		}
	}



	@Override
	public boolean doUpdatePassword(String user, String pass) throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		String insertSQL = "UPDATE CLIENTE SET PASSWORD = ? WHERE CF = ?";

		try {
			
			connection = DriverManagerConnectionPool.getConnection();
			preparedStatement = connection.prepareStatement(insertSQL);
			preparedStatement.setString(1, pass);
			preparedStatement.setString(2, user);
			
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
	public boolean doUpdateEmail(String codiceUtente, String email) throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		String insertSQL = "UPDATE CLIENTE SET email = ? WHERE CF = ?";

		try {
			
			connection = DriverManagerConnectionPool.getConnection();
			preparedStatement = connection.prepareStatement(insertSQL);
			preparedStatement.setString(1, email);
			preparedStatement.setString(2, codiceUtente);
			
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
	public boolean doUpdateDateGestore(String codiceFiscale, Date nuovaData, String attributo) throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		String insertSQL = "";
		
		if(attributo.equalsIgnoreCase("data1")) {
			try {
				insertSQL = "UPDATE GESTORERIPARAZIONI SET DATA1 = ? WHERE CFGESTORER = ?";
				connection = DriverManagerConnectionPool.getConnection();
				preparedStatement = connection.prepareStatement(insertSQL);
				preparedStatement.setDate(1, nuovaData);
				preparedStatement.setString(2, codiceFiscale);
				
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
		}else
			if(attributo.equalsIgnoreCase("data2")) {
				try {
					insertSQL = "UPDATE GESTORERIPARAZIONI SET DATA2 = ? WHERE CFGESTORER = ?";
					connection = DriverManagerConnectionPool.getConnection();
					preparedStatement = connection.prepareStatement(insertSQL);
					preparedStatement.setDate(1, nuovaData);
					preparedStatement.setString(2, codiceFiscale);
					
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
			}else {
				try {
					insertSQL = "UPDATE GESTORERIPARAZIONI SET DATA3 = ? WHERE CFGESTORER = ?";
					connection = DriverManagerConnectionPool.getConnection();
					preparedStatement = connection.prepareStatement(insertSQL);
					preparedStatement.setDate(1, nuovaData);
					preparedStatement.setString(2, codiceFiscale);
					
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

	@Override
	public boolean doUpdateCliente(UserBean cliente, String ruolo) throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		PreparedStatement preparedStatement2 = null;
		PreparedStatement preparedStatement3 = null;
		PreparedStatement preparedStatement4 = null;
		
		String updateSQL = "UPDATE cliente SET ruolo = ? WHERE cf = ?";
		
		String insertSQL = "INSERT INTO gestore (CFGESTORE,RUOLO) VALUES (?,?)";
		String insertSQL1 = "INSERT INTO GESTOREPRODOTTI(CFGESTOREP) VALUES (?)";
		String insertSQL2 = "INSERT INTO GESTORERIPARAZIONI (CFGESTORER,DATA1,DATA2,DATA3) VALUES (?,?,?,?)";
		
		String deleteSQL = "DELETE FROM CLIENTEREGISTRATO WHERE CFCLIENTEREGISTRATO = ?";
		
			try {
				
				connection = DriverManagerConnectionPool.getConnection();
				preparedStatement = connection.prepareStatement(updateSQL);
				preparedStatement.setString(1, ruolo);
				preparedStatement.setString(2, cliente.getCf());
				
				preparedStatement.executeUpdate();
				
				connection.commit();
				
				preparedStatement2 = connection.prepareStatement(insertSQL);
				preparedStatement2.setString(1, cliente.getCf());
				preparedStatement2.setString(2, ruolo);
				preparedStatement2.executeUpdate();
				
				connection.commit();
				
				preparedStatement4 = connection.prepareStatement(deleteSQL);
				preparedStatement4.setString(1, cliente.getCf());
				preparedStatement4.executeUpdate();
				
				connection.commit();
				
				if(ruolo.equalsIgnoreCase("gestoreprodotti")) {
					preparedStatement3 = connection.prepareStatement(insertSQL1);
					preparedStatement3.setString(1, cliente.getCf());
					preparedStatement3.executeUpdate();
					
					connection.commit();
				}else {
					preparedStatement3 = connection.prepareStatement(insertSQL2);
					preparedStatement3.setString(1, cliente.getCf());
					preparedStatement3.setDate(2, null);
					preparedStatement3.setDate(3, null);
					preparedStatement3.setDate(4, null);
					preparedStatement3.executeUpdate();
					
					connection.commit();
				}
				
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









	

