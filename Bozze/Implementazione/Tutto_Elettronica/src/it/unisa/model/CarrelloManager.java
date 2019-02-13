package it.unisa.model;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;

import it.unisa.bean.CarrelloBean;
import it.unisa.bean.ProdottoInMagazzinoBean;

public interface CarrelloManager<T> {
	

	public CarrelloBean<T> doRetrieveByKey(String codiceCliente) throws SQLException;
	
	public boolean doInsertProdotti(CarrelloBean carrello) throws SQLException;
	
	public boolean doDeleteProdotti(CarrelloBean carrello) throws SQLException;

	public boolean doPrenota(String codiceCliente, ProdottoInMagazzinoBean prodotto)throws SQLException;

	
}
