package testUtente;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import it.unisa.bean.ProdottoBean;
import it.unisa.model.UserManagerDM;
import junit.framework.TestCase;

public class TestDoRetrieveByCodiceFiscale extends TestCase{

private UserManagerDM usr;
	
	@Before
	@Override
	protected void setUp() throws Exception {
		// TODO Auto-generated method stub
		super.setUp();
		
		usr = new UserManagerDM();
	
	}
	
	@After
	@Override
	protected void tearDown() throws Exception {
		// TODO Auto-generated method stub
		super.tearDown();
		usr.doDelete("CMMGTN80A01C361H");
	}
	
	@Test
	public void testDoRetrieveByCodiceFiscale() throws Exception{
		ArrayList<ProdottoBean> coll =  (ArrayList<ProdottoBean>) usr.doRetrieveByCodiceFiscale("CMMGTN80A01C361Z", "prodottoprenotato");
		
		assertEquals(1,coll.get(0).getIdProdotto());
	}  
	
}
