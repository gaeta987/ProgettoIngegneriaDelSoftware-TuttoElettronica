package it.unisa.model;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;

public interface MerceModel<T> {
	
	public T doRetrieveByKey(int code, String tipo)throws SQLException;
	
	public Collection<ProdottoInMagazzinoBean> doRetrieveAll()throws SQLException;
	
	public void doSave(T product)throws SQLException;
	
	public void doUpdate(T product)throws SQLException;
	
	public String doRetrieveURL(int code) throws SQLException;
	public boolean doDelete(int code)throws SQLException;
	
	public void setFormato(String parola,int codice)throws SQLException;
	public Collection<T> doRetrieveAllFormato(String parola)throws SQLException;
	
	public Collection<T> doRetrieveAllFormatoP(String parola)throws SQLException;
	
	public ArrayList<T> doRetrieveCategoria(String parola)throws SQLException;
}
