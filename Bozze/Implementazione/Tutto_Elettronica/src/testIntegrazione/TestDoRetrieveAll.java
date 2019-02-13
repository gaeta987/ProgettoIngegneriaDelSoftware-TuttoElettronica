package testIntegrazione;

import java.sql.Date;
import java.sql.SQLException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import it.unisa.bean.ProdottoBean;
import it.unisa.model.ProdottoManagerDM;
import it.unisa.model.RiparazioneManagerDM;
import junit.framework.TestCase;

public class TestDoRetrieveAll extends TestCase {
	
	ProdottoManagerDM pmd;
	ProdottoBean prodotto;
	RiparazioneManagerDM rmd;
	
	@Before
	@Override
	protected void setUp() throws Exception {
		pmd =  new ProdottoManagerDM();
		prodotto =  new ProdottoBean();
		rmd =  new RiparazioneManagerDM();
	}
	
	@After
	@Override
	protected void tearDown() throws Exception {
		// TODO Auto-generated method stub
		super.tearDown();
	}
	
	@Test
	public void testDoRetrieveAll() throws SQLException {
		String data1 = "2019-01-30";
		String data2 = "2019-02-05";
		String data3 = "2019-02-25";
		
		Date[] collection = (Date[]) rmd.doRetrieveAll();
		
		for(int i = 0; i < collection.length; i++) {
			assertEquals(data1, collection[0].toString());
			assertEquals(data2, collection[1].toString());
			assertEquals(data3, collection[2].toString());
		}	
	}
}
