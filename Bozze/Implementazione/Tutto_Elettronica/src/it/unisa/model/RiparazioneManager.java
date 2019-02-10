package it.unisa.model;

import java.sql.Date;
import java.sql.SQLException;
import java.util.Collection;

public interface RiparazioneManager  {
	
	public boolean doUpdateData(Date data, int idRiparazione) throws SQLException;
	
	public boolean doUpdateStato(String stato, int idRiparazione) throws SQLException;
	
	public Date[] doRetrieveAll() throws SQLException;

	public void doSaveRiparazione(ProdottoBean prodotto, Date data, String codiceCliente) throws SQLException;
	
	public Collection<ProdottoInRiparazioneBean> doRetrieveAllRiparazioni() throws SQLException;
}
