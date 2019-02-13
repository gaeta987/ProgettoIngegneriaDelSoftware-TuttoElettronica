package testIntegrazione1;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import it.unisa.bean.CarrelloBean;
import it.unisa.model.CarrelloManagerDM;
import junit.framework.TestCase;

public class TestDoRetrieveByKeyCarrello extends TestCase {
	
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
	public void testDoRetrieveByKey() throws Exception{
		CarrelloBean carrello = new CarrelloBean();
		
		carrello.setId(1);
		
		CarrelloBean result = crm.doRetrieveByKey("CMMGTN80A01C361Z");
		
		assertEquals(carrello.getId(), result.getId());
		
	}

}
