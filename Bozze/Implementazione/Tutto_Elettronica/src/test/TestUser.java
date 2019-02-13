package test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import it.unisa.bean.CarrelloBean;
import it.unisa.model.CarrelloManagerDM;
import it.unisa.bean.ProdottoBean;
import it.unisa.bean.ProdottoInMagazzinoBean;
import it.unisa.bean.UserBean;
import it.unisa.model.UserManagerDM;
import junit.framework.TestCase;

public class TestUser extends TestCase {
	
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
	public void testDoRetrieveByKey() throws Exception{
		UserBean user = new UserBean();
		user.setCf("CMMGTN80A01C361Z");
		user.setCognome("Cimmino");
		user.setNome("Gaetano");
		user.setEmail("gaetano@gmail.com");
		user.setIndirizzo("via roma");
		user.setPassword("ggg123");
		user.setUsername("ggg");
		user.setRuolo("cliente");
		
		UserBean result = usr.doRetrieveByKey("CMMGTN80A01C361Z");
		
		assertEquals(user.getCf(), result.getCf());
		
	}
	
	@Test
	public void testDoRetrieveUtente() throws Exception{
		UserBean user = usr.doRetrieveByKey("CMMGTN80A01C361Z");
		
		UserBean result = usr.doRetrieveUtente("ggg", "ggg123");
		
		assertEquals(user.getCf(),result.getCf());
	}
	
	@Test
	public void testDoRetrieveAll() throws Exception{
		UserBean user = usr.doRetrieveByKey("CMMGTN80A01C361B");
		
		ArrayList<UserBean> coll =  (ArrayList<UserBean>) usr.doRetrieveAll();
		
		assertEquals(user.getCf(),coll.get(1).getCf());
	}
	
	@Test
	public void testDoSaveClienteRegistrato() throws Exception{
		UserBean user = new UserBean();
		user.setCf("CMMGTN80A01C361H");
		user.setCognome("Cimmino");
		user.setNome("Gaetano");
		user.setEmail("gaetano@gmail.com");
		user.setIndirizzo("via roma");
		user.setPassword("ggg123");
		user.setUsername("ggg");
		user.setRuolo("cliente");
		
		usr.doSave(user);
		usr.doSaveClienteRegistrato(user);
		
		UserBean result = usr.doRetrieveByKey("CMMGTN80A01C361H");
		
		assertEquals(user.getCf(),result.getCf());
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
	
	@Test
	public void testDoDelete() throws Exception{
		UserBean user = usr.doRetrieveByKey("CMMGTN80A01C361T");
		
		assertEquals(true, usr.doDelete(user.getCf()));
	}
	
	@Test
	public void testDoUpdatePassword() throws Exception{
		UserBean user = usr.doRetrieveByKey("CMMGTN80A01C361B");
		
		usr.doUpdatePassword(user.getCf(), "123456");
		
		assertEquals("123456", usr.doRetrieveByKey("CMMGTN80A01C361B").getPassword());
	}
	
	@Test
	public void testDoUpdateEmail() throws Exception{
		UserBean user = usr.doRetrieveByKey("CMMGTN80A01C361B");
		
		usr.doUpdateEmail(user.getCf(), "boh@gmail.com");
		
		assertEquals("boh@gmail.com", usr.doRetrieveByKey("CMMGTN80A01C361B").getEmail());
	}

	
	
/*	@Test
	public void testDoUpdateDateGestore() throws Exception{
		

		SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd");

		String data = "2019-05-25";
		java.util.Date date = null;
		date = sdf1.parse(data);
		
		java.sql.Date sqlData = new java.sql.Date(date.getTime());
		
		
		
		assertEquals(true, usr.doUpdateDateGestore("CMMGTN80A01C361Z", sqlData, "data1"));
	}    */

	@Test
	public void testDoRetrieveByCodiceFiscale() throws Exception{
		ArrayList<ProdottoBean> coll =  (ArrayList<ProdottoBean>) usr.doRetrieveByCodiceFiscale("CMMGTN80A01C361Z", "prodottoprenotato");
		
		assertEquals(1,coll.get(0).getIdProdotto());
	}  

/*	@Test
	public void testDoUpdateCliente()throws Exception{
		UserBean user = usr.doRetrieveByKey("CMMGTN80A01C361V");
		
		usr.doUpdateCliente(user, "gestoreProdotti");
		
		assertEquals("gestoreProdotti",usr.doRetrieveByKey("CMMGTN80A01C361V").getRuolo());
	}   */   
}
