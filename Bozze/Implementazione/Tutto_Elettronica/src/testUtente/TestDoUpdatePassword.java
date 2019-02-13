package testUtente;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import it.unisa.bean.UserBean;
import it.unisa.model.UserManagerDM;
import junit.framework.TestCase;

public class TestDoUpdatePassword extends TestCase {

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
	public void testDoUpdatePassword() throws Exception{
		UserBean user = usr.doRetrieveByKey("CMPGTN95A01C361B");
		
		usr.doUpdatePassword(user.getCf(), "123456");
		
		assertEquals("123456", usr.doRetrieveByKey("CMPGTN95A01C361B").getPassword());
	}
	
}
