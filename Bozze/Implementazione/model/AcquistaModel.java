package it.unisa.model;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public interface AcquistaModel{
	
	public void doAcquista(String username, ProdottoInMagazzinoBean prodotto)throws SQLException;

	public ArrayList<Integer> doRetrieveAllCode(String username) throws SQLException;
	
	public void doElimina(int code) throws SQLException;

}
