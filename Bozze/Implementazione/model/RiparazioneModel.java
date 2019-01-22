package it.unisa.model;

import java.sql.Date;
import java.sql.SQLException;
import java.util.Collection;

public interface RiparazioneModel  {
	
	public void doSave(Date data) throws SQLException;
	
	public void doUpdate(Date data) throws SQLException;
	
	public void doUpdateRiparazione(ProdottoInRiparazioneBean prodotto) throws SQLException;
	
	public Date[] doRetrieveAll() throws SQLException;

	public void doSaveRiparazione(ProdottoBean prodotto, Date data, String codiceCliente) throws SQLException;
}
