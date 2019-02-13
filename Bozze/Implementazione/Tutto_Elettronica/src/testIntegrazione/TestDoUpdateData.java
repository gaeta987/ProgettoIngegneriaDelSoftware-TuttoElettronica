package testIntegrazione;

import java.sql.Date;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import it.unisa.bean.ProdottoBean;
import it.unisa.bean.ProdottoInRiparazioneBean;
import it.unisa.model.ProdottoManagerDM;
import it.unisa.model.RiparazioneManagerDM;
import junit.framework.TestCase;

public class TestDoUpdateData extends TestCase {
	
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
	public void testDoUpdateData() throws ParseException, SQLException {
		String dataFine = "2019-02-08";
		
		SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd");
		java.util.Date date = null;
			date = sdf1.parse(dataFine);
			// TODO Auto-generated catch block

		Date sqlData2 = new java.sql.Date(date.getTime());

		ProdottoInRiparazioneBean prodottoRiparazione =  new ProdottoInRiparazioneBean();
		prodottoRiparazione.setIdPrenotazione(1);
		prodotto.setIdProdotto(4);
		rmd.doUpdateData(sqlData2, prodottoRiparazione.getIdPrenotazione());
		
		ArrayList<ProdottoInRiparazioneBean> collection = (ArrayList<ProdottoInRiparazioneBean>) rmd.doRetrieveAllRiparazioni();
		
		
		assertEquals(sqlData2 ,collection.get(0).getDataFineLavoro());
	}
	
}
