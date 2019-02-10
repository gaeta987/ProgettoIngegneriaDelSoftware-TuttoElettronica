package it.unisa.model;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;

public interface CarrelloManager<T> {
	

	public Carrello<T> doRetrieveByKey(String codiceCliente) throws SQLException;
	
	public boolean doInsertProdotti(Carrello carrello) throws SQLException;
	
	public boolean doDeleteProdotti(Carrello carrello) throws SQLException;

	public boolean doPrenota(String codiceCliente, ProdottoInMagazzinoBean prodotto)throws SQLException;

	
}
