package it.unisa.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;


public class MerceModelDM implements MerceModel<ProdottoBean> {

	public MerceModelDM() {
		
	}

	
	@Override
	public Collection<ProdottoInMagazzinoBean> doRetrieveAll() throws SQLException {
		Connection connection=null;
		PreparedStatement preparedStatement=null;
		Collection<ProdottoInMagazzinoBean> products=new LinkedList<ProdottoInMagazzinoBean>();
		
		String selectSQL="SELECT * FROM PRODOTTO AS P, PRODOTTOINMAGAZZINO AS M WHERE P.CODICE=M.IDPM";
		
		try {
			
			connection=DriverManagerConnectionPool.getConnection();
			preparedStatement=connection.prepareStatement(selectSQL);
			
			ResultSet rs=preparedStatement.executeQuery();
			while(rs.next()) {
				ProdottoInMagazzinoBean bean=new ProdottoInMagazzinoBean();
				bean.setIdProdotto(rs.getInt("CODICE"));
				bean.setCosto(Double.parseDouble(rs.getString("PREZZO")));
				bean.setDescrizione(rs.getString("DESCRIZIONE"));
				bean.setImmagine(rs.getString("IMMAGINE"));
				bean.setTipo(rs.getString("CATEGORIA"));
				bean.setNome(rs.getString("NOME"));
				bean.setMarca(rs.getString("MARCA"));
				bean.setPromo(rs.getBoolean("PROMO"));
				bean.setQuantita(rs.getInt("QUANTITA"));
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
	public String doRetrieveURL(int code) throws SQLException {
		Connection connection=null;
		PreparedStatement preparedStatement=null;
		String bean="";
		
		String selectSQL="SELECT IMMAGINE FROM PRODOTTO WHERE CODICE= ?";
		
		try {
			
			connection=DriverManagerConnectionPool.getConnection();
			preparedStatement=connection.prepareStatement(selectSQL);
			preparedStatement.setInt(1, code);
			
			
			ResultSet rs=preparedStatement.executeQuery();
			while(rs.next()) {
				
				bean+=rs.getString("IMMAGINE");
				
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
	public ProdottoBean doRetrieveByKey(int code, String tipoProdotto) throws SQLException {
		Connection connection=null;
		PreparedStatement preparedStatement=null;
		
		if(tipoProdotto.equalsIgnoreCase("prodottoinmagazzino")){
			String selectSQL="SELECT * FROM PRODOTTOINMAGAZZINO AS M, PRODOTTO AS P WHERE M.IDPM= ? && P.CODICE=M.IDPM";
			
			try {
				
				connection=DriverManagerConnectionPool.getConnection();
				preparedStatement=connection.prepareStatement(selectSQL);
				preparedStatement.setInt(1, code);
				
				
				ResultSet rs=preparedStatement.executeQuery();
				ProdottoInMagazzinoBean bean=new ProdottoInMagazzinoBean();
				while(rs.next()) {
					bean.setIdProdotto(rs.getInt("CODICE"));
					bean.setCosto(Double.parseDouble(rs.getString("PREZZO")));
					bean.setDescrizione(rs.getString("DESCRIZIONE"));
					bean.setImmagine(rs.getString("IMMAGINE"));
					bean.setTipo(rs.getString("CATEGORIA"));
					bean.setNome(rs.getString("NOME"));
					bean.setMarca(rs.getString("MARCA"));
					bean.setPromo(rs.getBoolean("PROMO"));
					bean.setQuantita(rs.getInt("QUANTITA"));
					return bean;
					
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
			if(tipoProdotto.equalsIgnoreCase("prodottoprenotato")) {
				String selectSQL="SELECT * FROM PRODOTTOPRENOTATO AS PP, PRODOTTO AS P WHERE PP.IDPRENOTAZIONEPRODOTTO= ? && P.CODICE=PP.IDPRENOTAZIONEPRODOTTO";
				
				try {
					
					connection=DriverManagerConnectionPool.getConnection();
					preparedStatement=connection.prepareStatement(selectSQL);
					preparedStatement.setInt(1, code);
					
					
					ResultSet rs=preparedStatement.executeQuery();
					ProdottoPrenotatoBean bean = new ProdottoPrenotatoBean();
					while(rs.next()) {
						bean.setIdProdotto(rs.getInt("CODICE"));
						bean.setCosto(Double.parseDouble(rs.getString("PREZZO")));
						bean.setDescrizione(rs.getString("DESCRIZIONE"));
						bean.setImmagine(rs.getString("IMMAGINE"));
						bean.setTipo(rs.getString("CATEGORIA"));
						bean.setNome(rs.getString("NOME"));
						bean.setMarca(rs.getString("MARCA"));
						bean.setQuantita(rs.getInt("QUANTITA"));
						bean.setIdPrenotazioneProdotto(rs.getInt("IDPRENOTAZIONEPRODOTTO"));
						bean.setCodiceCliente(rs.getString("CFCLIENTE"));
						bean.setPrezzo(rs.getDouble("PREZZO"));
						bean.setDataPrenotazione(rs.getDate("DATAPRENOTAZIONE"));
						return bean;
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
					String selectSQL="SELECT * FROM PRODOTTO AS P, PRODOTTOINRIPARAZIONE AS R WHERE R.IDPR= ? && P.CODICE=R.IDPR";
					
					try {
						
						connection=DriverManagerConnectionPool.getConnection();
						preparedStatement=connection.prepareStatement(selectSQL);
						preparedStatement.setInt(1, code);
						
						
						ResultSet rs=preparedStatement.executeQuery();
						ProdottoInRiparazioneBean bean=new ProdottoInRiparazioneBean();
						while(rs.next()) {
							bean.setIdProdotto(rs.getInt("CODICE"));
							bean.setCosto(Double.parseDouble(rs.getString("PREZZO")));
							bean.setDescrizione(rs.getString("DESCRIZIONE"));
							bean.setImmagine(rs.getString("IMMAGINE"));
							bean.setTipo(rs.getString("CATEGORIA"));
							bean.setNome(rs.getString("NOME"));
							bean.setMarca(rs.getString("MARCA"));
							bean.setQuantita(rs.getInt("QUANTITA"));
							bean.setIdPrenotazione(rs.getInt("IDPRENOTAZIONERIPARAZIONE"));
							bean.setDataIncontro(rs.getDate("dataincontro"));
							bean.setCodiceCliente(rs.getString("CFCLIENTE"));
							bean.setStatoRiparazione(rs.getString("STATORIPARAZIONE"));
							bean.setDescrizioneProblema(rs.getString("DESCRIZIONEPROBLEMA"));
							return bean;
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
		return null;
	}

/*	
	@Override
	public void doSave(ProdottoBean product) throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		String insertSQL = "INSERT INTO MERCE" 
				+ " (CODICE, NOME, TIPO, PREZZO, QUANTITA, MARCA, DESCRIZIONE, IMMAGINE, PROMO, TIPOLOGIAPRODOTTO) VALUES (?, ?,?, ?, ?, ?, ?, ?)";

		try {
			connection = DriverManagerConnectionPool.getConnection();
			preparedStatement = connection.prepareStatement(insertSQL);
			preparedStatement.setInt(1, product.getCodice());
			preparedStatement.setString(2, product.getNome());
			preparedStatement.setString(3, product.getTipo());
			preparedStatement.setDouble(4, product.getCosto());
			preparedStatement.setDouble(5, product.getCosto_prom());
			preparedStatement.setString(6, product.getFormato());
			preparedStatement.setString(7, product.getDescrizione());
			preparedStatement.setString(8, product.getUrl());
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
	public void doUpdate(MerceBean product) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean doDelete(int code) throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		int result = 0;

		String deleteSQL = "DELETE FROM MERCE"+ " WHERE CODICE = ?";

		try {
			connection = DriverManagerConnectionPool.getConnection();
			preparedStatement = connection.prepareStatement(deleteSQL);
			preparedStatement.setInt(1, code);

			
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
	public Collection<MerceBean> doRetrieveAllFormato(String parola) throws SQLException {
		Connection connection=null;
		PreparedStatement preparedStatement=null;
		Collection<MerceBean> products=new LinkedList<MerceBean>();
		
		String selectSQL="SELECT * FROM MERCE WHERE FORMATO=?";
		
		try {
			
			connection=DriverManagerConnectionPool.getConnection();
			preparedStatement=connection.prepareStatement(selectSQL);
			preparedStatement.setString(1, parola);
			ResultSet rs=preparedStatement.executeQuery();
			while(rs.next()) {
				MerceBean bean=new MerceBean();
				bean.setCodice(rs.getInt("CODICE"));
				bean.setCosto(Double.parseDouble(rs.getString("COSTO")));
				bean.setDescrizione(rs.getString("DESCRIZIONE"));
				bean.setCosto_prom(Double.parseDouble(rs.getString("COSTO_PROM")));
				bean.setUrl(rs.getString("URL"));
				bean.setTipo(rs.getString("TIPO"));
				bean.setNome(rs.getString("NOME"));
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
	public void setFormato(String parola, int codice) throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		String insertSQL = "UPDATE MERCE SET FORMATO = ? WHERE CODICE = ?";

		try {
			
			connection = DriverManagerConnectionPool.getConnection();
			preparedStatement = connection.prepareStatement(insertSQL);
			preparedStatement.setString(1, parola);
			preparedStatement.setInt(2, codice);
			
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
*/

	@Override
	public ArrayList<ProdottoBean> doRetrieveCategoria(String parola) throws SQLException {
		Connection connection=null;
		PreparedStatement preparedStatement=null;
		ArrayList<ProdottoBean> products=new ArrayList<ProdottoBean>();
		
		String selectSQL="SELECT * FROM PRODOTTOINMAGAZZINO AS M, PRODOTTO AS P WHERE P.CATEGORIA=? && M.IDPM=P.CODICE";
		
		try {
			
			connection=DriverManagerConnectionPool.getConnection();
			preparedStatement=connection.prepareStatement(selectSQL);
			preparedStatement.setString(1, parola);
			ResultSet rs=preparedStatement.executeQuery();
			while(rs.next()) {
				ProdottoInMagazzinoBean bean=new ProdottoInMagazzinoBean();
				bean.setIdProdotto(rs.getInt("CODICE"));
				bean.setCosto(Double.parseDouble(rs.getString("PREZZO")));
				bean.setDescrizione(rs.getString("DESCRIZIONE"));
				bean.setImmagine(rs.getString("IMMAGINE"));
				bean.setTipo(rs.getString("CATEGORIA"));
				bean.setNome(rs.getString("NOME"));
				bean.setMarca(rs.getString("MARCA"));
				bean.setQuantita(rs.getInt("QUANTITA"));
				bean.setPromo(rs.getBoolean("PROMO"));
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
public void doSave(ProdottoBean product) throws SQLException {
	// TODO Auto-generated method stub
	
}


@Override
public void doUpdate(ProdottoBean product) throws SQLException {
	// TODO Auto-generated method stub
	
}


@Override
public boolean doDelete(int code) throws SQLException {
	// TODO Auto-generated method stub
	return false;
}


@Override
public void setFormato(String parola, int codice) throws SQLException {
	// TODO Auto-generated method stub
	
}


@Override
public Collection<ProdottoBean> doRetrieveAllFormato(String parola) throws SQLException {
	// TODO Auto-generated method stub
	return null;
}


@Override
public Collection<ProdottoBean> doRetrieveAllFormatoP(String parola) throws SQLException {
	// TODO Auto-generated method stub
	return null;
}
}

/*
	@Override
	public Collection<MerceBean> doRetrieveAllFormatoP(String parola) throws SQLException {
		Connection connection=null;
		PreparedStatement preparedStatement=null;
		Collection<MerceBean> products=new LinkedList<MerceBean>();
		
		String selectSQL="SELECT * FROM MERCE WHERE FORMATO=?&&COSTO_PROM>0";
		
		try {
			
			connection=DriverManagerConnectionPool.getConnection();
			preparedStatement=connection.prepareStatement(selectSQL);
			preparedStatement.setString(1, parola);
			ResultSet rs=preparedStatement.executeQuery();
			while(rs.next()) {
				MerceBean bean=new MerceBean();
				bean.setCodice(rs.getInt("CODICE"));
				bean.setCosto(Double.parseDouble(rs.getString("COSTO")));
				bean.setDescrizione(rs.getString("DESCRIZIONE"));
				bean.setCosto_prom(Double.parseDouble(rs.getString("COSTO_PROM")));
				bean.setUrl(rs.getString("URL"));
				bean.setTipo(rs.getString("TIPO"));
				bean.setNome(rs.getString("NOME"));
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
}
*/
	


