package it.unisa.model;

import java.sql.Date;
import java.sql.SQLException;
import java.util.Collection;

public interface UserManager<T> {
	
	public T doRetrieveUtente(String username,String Password)throws SQLException;
	
	public Collection<T> doRetrieveAll()throws SQLException;
	
	public boolean doSave(T cliente)throws SQLException;
	
	public boolean doDelete(String user)throws SQLException;
	
	public boolean doUpdatePassword(String user,String pass)throws SQLException;
	
	public boolean doUpdateEmail(String codiceUtente, String Email) throws SQLException;
	
	public UserBean doRetrieveByKey(String codiceFiscale) throws SQLException;
	
	public boolean doUpdateDateGestore(String codiceFiscale, Date nuovaData, String attributo) throws SQLException;
	
	public boolean doSaveClienteRegistrato(UserBean cliente) throws SQLException;
	
	public Collection<ProdottoBean> doRetrieveByCodiceFiscale(String codiceFiscale, String tipoProdotto) throws SQLException;
	
	public boolean doUpdateCliente(UserBean cliente, String ruolo) throws SQLException;
	
}
