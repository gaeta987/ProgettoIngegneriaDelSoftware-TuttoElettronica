package testUtente;

import java.text.SimpleDateFormat;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import it.unisa.model.UserManagerDM;
import junit.framework.TestCase;

public class TestDoUpdateDataGestore extends TestCase{

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
	public void testDoUpdateDateGestore() throws Exception{
		

		SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd");

		String data = "2019-05-25";
		java.util.Date date = null;
		date = sdf1.parse(data);
		
		java.sql.Date sqlData = new java.sql.Date(date.getTime());
		
		
		
		assertEquals(true, usr.doUpdateDateGestore("CMNGTN80A01C361Z", sqlData, "data1"));
	}   
	
}
