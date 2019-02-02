package it.unisa.model;

import java.sql.Date;
import java.sql.SQLException;
import java.util.Collection;

public interface UserManager<T> {
	
	public T doRetrieveUtente(String username,String Password)throws SQLException;
	
	public Collection<T> doRetrieveAll()throws SQLException;
	
	public void doSave(T cliente)throws SQLException;
	
	public void doDelete(String user)throws SQLException;
	
	public void doUpdatePassword(String user,String pass)throws SQLException;
	
	public void doUpdateEmail(String codiceUtente, String Email) throws SQLException;
	
	public UserBean doRetrieveByKey(String codiceFiscale) throws SQLException;
	
	public void doUpdateDateGestore(String codiceFiscale, Date nuovaData, String attributo) throws SQLException;
	
	public void doSaveClienteRegistrato(UserBean cliente) throws SQLException;
	
	public Collection<ProdottoBean> doRetrieveByCodiceFiscale(String codiceFiscale, String tipoProdotto) throws SQLException;
	
	public void doUpdateCliente(UserBean cliente, String ruolo) throws SQLException;
	
}
