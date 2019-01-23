package it.unisa.model;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;

public interface MerceModel<T> {
	
	public T doRetrieveByKey(int code, String tipo)throws SQLException;
	
	public Collection<ProdottoInMagazzinoBean> doRetrieveAll()throws SQLException;
	
	public void doUpdateQuantitaNelCarrello(int codice, int quantita)throws SQLException;
	
	public void doUpdateQuantitaInMagazzino(int codice, int quantita)throws SQLException;
	
	public String doRetrieveURL(int code) throws SQLException;
	
	public boolean doDelete(int code)throws SQLException;
	
	public ArrayList<T> doRetrieveCategoria(String parola)throws SQLException;

	public void doSave(ProdottoBean product) throws SQLException;
	
	public Collection<T> doRetrieveByCodiceFiscale(String codiceFiscale, String tipoProdotto) throws SQLException;
}
