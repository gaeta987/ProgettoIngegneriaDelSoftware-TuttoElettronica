package it.unisa.model;

import java.sql.SQLException;
import java.util.Collection;

public interface RecensioneManager<T> {
	
	public void doSave(T recensione)throws SQLException;
}
