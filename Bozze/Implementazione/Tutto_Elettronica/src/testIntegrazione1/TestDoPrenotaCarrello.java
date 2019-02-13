package testIntegrazione1;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import it.unisa.bean.CarrelloBean;
import it.unisa.model.CarrelloManagerDM;
import it.unisa.bean.ProdottoInMagazzinoBean;
import junit.framework.TestCase;

public class TestDoPrenotaCarrello extends TestCase {
	
CarrelloManagerDM crm;
	
	@Before
	@Override
	protected void setUp() throws Exception {
		// TODO Auto-generated method stub
		super.setUp();
		
		crm = new CarrelloManagerDM();
	}
	
	@After
	@Override
	protected void tearDown() throws Exception {
		// TODO Auto-generated method stub
		super.tearDown();

	}

	@Test
	public void testDoPrenota() throws Exception{
		CarrelloBean carrello = new CarrelloBean();
		
		carrello = crm.doRetrieveByKey("CMMGTN80A01C361Z");
		
		assertEquals(true, crm.doPrenota("CMMGTN80A01C361Z", (ProdottoInMagazzinoBean)carrello.getList().get(0)));
		
	}

}
