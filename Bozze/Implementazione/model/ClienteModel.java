package it.unisa.model;

import java.sql.SQLException;
import java.util.Collection;

public interface ClienteModel<T> {
	
	public T doRetrieveUtente(String username,String Password)throws SQLException;
	
	public Collection<T> doRetrieveAll()throws SQLException;
	
	public Collection<T> doRetrieveAll2()throws SQLException;
	
	
	public void doSave(T product)throws SQLException;
	
	public void doUpdate(T product)throws SQLException;
	
	public boolean doDelete(String user)throws SQLException;
	
	public void doUpdateAdmin(String user)throws SQLException;
	
	public void doUpdateRuolo(String user)throws SQLException;
	
	public void doUpdatePassword(String user,String pass)throws SQLException;
}
