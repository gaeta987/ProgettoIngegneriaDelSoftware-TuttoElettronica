package it.unisa.model;

import java.sql.SQLException;
import java.util.Collection;

public interface RecensioneModel<T> {
public Collection<T> doRetrieveByKey(int code)throws SQLException;
	
	public Collection<T> doRetrieveAll()throws SQLException;
	
	public void doSave(T recensione)throws SQLException;
	
	public void doUpdate(T recensione)throws SQLException;
	
	public String doRetrieveURL(int code,String user) throws SQLException;
	public boolean doDelete(int code, String user)throws SQLException;
}
