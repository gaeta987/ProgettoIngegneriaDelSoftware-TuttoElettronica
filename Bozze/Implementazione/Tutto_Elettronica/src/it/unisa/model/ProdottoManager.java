package it.unisa.model;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;

import it.unisa.bean.ProdottoBean;
import it.unisa.bean.ProdottoInMagazzinoBean;

public interface ProdottoManager<T> {
	
	public T doRetrieveByKey(int code, String tipo)throws SQLException;
	
	public Collection<ProdottoInMagazzinoBean> doRetrieveAll()throws SQLException;
	
	public boolean doUpdateQuantitaNelCarrello(int codice, int quantita)throws SQLException;
	
	public boolean doUpdateQuantitaInMagazzino(int codice, int quantita)throws SQLException;
	
	public boolean doDelete(int code)throws SQLException;
	
	public ArrayList<T> doRetrieveCategoria(String parola)throws SQLException;

	public void doSave(ProdottoBean product) throws SQLException;
	
	public int doRetrieveLastKey() throws SQLException;
	
	public Collection<ProdottoInMagazzinoBean> doRetrieveOnSale() throws SQLException;
	
	public boolean doSaveInMagazzino(ProdottoBean prodotto, boolean promo, int quantita)throws SQLException;
	
	public boolean doUpdatePromo(int codice, String tipo) throws SQLException;
	
	public boolean doUpdatePrezzo(int codice, double nuovoPrezzo) throws SQLException;
}
