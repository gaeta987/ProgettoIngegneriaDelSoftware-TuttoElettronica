package testUtente;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import it.unisa.bean.UserBean;
import it.unisa.model.UserManagerDM;
import junit.framework.TestCase;

public class TestDoSave extends TestCase{

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
	public void testDoSave() throws Exception{
		UserBean user = new UserBean();
		user.setCf("CMMGTN80A01C361T");
		user.setCognome("Cimmino");
		user.setNome("Gaetano");
		user.setEmail("gaetano@gmail.com");
		user.setIndirizzo("via roma");
		user.setPassword("ggg123");
		user.setUsername("ggg4");
		user.setRuolo("cliente");
		
		usr.doSave(user);
		
		UserBean result = usr.doRetrieveByKey("CMMGTN80A01C361T");
		
		assertEquals(user.getCf(),result.getCf());
	}
	
}
