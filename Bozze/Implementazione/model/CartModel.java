package it.unisa.model;

import java.sql.SQLException;
import java.util.Collection;

public interface CartModel<T> {
	

	public Cart<T> doRetrieveByKey(String codiceCliente) throws SQLException;
	public void doUpdateProdotti(Cart carrello) throws SQLException;
	public void doInsertProdotti(Cart carrello) throws SQLException;

}
