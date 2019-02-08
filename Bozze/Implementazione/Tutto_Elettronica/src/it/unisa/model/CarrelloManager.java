package it.unisa.model;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;

public interface CarrelloManager<T> {
	

	public Carrello<T> doRetrieveByKey(String codiceCliente) throws SQLException;
	
	public void doInsertProdotti(Carrello carrello) throws SQLException;
	
	public void doDeleteProdotti(Carrello carrello) throws SQLException;

	public void doPrenota(String codiceCliente, ProdottoInMagazzinoBean prodotto)throws SQLException;

	public ArrayList<Integer> doRetrieveAllCode(String username) throws SQLException;
}
