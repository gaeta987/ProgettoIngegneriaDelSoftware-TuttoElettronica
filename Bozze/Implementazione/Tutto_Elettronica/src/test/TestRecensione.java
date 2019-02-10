package test;

import java.sql.SQLException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import it.unisa.model.RecensioneManagerDM;
import it.unisa.model.Recensionie;
import it.unisa.model.UserBean;
import it.unisa.model.UserManagerDM;
import junit.framework.TestCase;

public class TestRecensione extends TestCase{

	Recensionie recensione;
	RecensioneManagerDM rmd;
	UserBean userBean;
	UserManagerDM umd;
	
	@Before
	@Override
	protected void setUp() throws Exception {
		// TODO Auto-generated method stub
		super.setUp();
		
		userBean = new UserBean();
		umd =  new UserManagerDM();
		rmd =  new RecensioneManagerDM();
		recensione = new Recensionie();

		recensione.setCodiceCliente("CMMGTN80A01C361Z");
		recensione.setCodiceProdotto(1);
		recensione.setId(1);
		recensione.setTesto("Gaetano è gay");
		recensione.setVoto(4);
	}
	
	@After
	@Override
	protected void tearDown() throws Exception {
		// TODO Auto-generated method stub
		super.tearDown();
	}
	
	@Test
	public void testDoSave() throws SQLException {
		
		rmd.doSave(recensione);
		
		userBean = umd.doRetrieveByKey(recensione.getCodiceCliente());
		
		assertEquals(recensione.getCodiceCliente(), userBean.getCf());
	}
}
