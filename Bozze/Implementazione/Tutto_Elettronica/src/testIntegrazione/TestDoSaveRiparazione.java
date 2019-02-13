package testIntegrazione;

import java.sql.Date;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import it.unisa.bean.ProdottoBean;
import it.unisa.bean.ProdottoInRiparazioneBean;
import it.unisa.model.ProdottoManagerDM;
import it.unisa.model.RiparazioneManagerDM;
import junit.framework.TestCase;

public class TestDoSaveRiparazione extends TestCase {

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
	public void testDoSaveRiparazione() throws SQLException, ParseException {
		
		String dataInizio = "2019-01-11";
		
		SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd");
		java.util.Date date = null;
			date = sdf1.parse(dataInizio);
			// TODO Auto-generated catch block

		Date sqlData = new java.sql.Date(date.getTime());
		
		prodotto.setCosto(10);
		prodotto.setDescrizione("ciao sono arduino");
		prodotto.setMarca("arduino");
		prodotto.setTipo("arduino");
		prodotto.setNome("arduino UNO");
		prodotto.setImmagine("arduino.jpg");
		
		pmd.doSave(prodotto);
		prodotto.setIdProdotto(pmd.doRetrieveLastKey());
		rmd.doSaveRiparazione(prodotto, sqlData, "CMMGTN80A01C361Z");
		
		assertEquals("CMMGTN80A01C361Z", ((ProdottoInRiparazioneBean) pmd.doRetrieveByKey(prodotto.getIdProdotto(),"prodottoinriparazione")).getCodiceCliente());
	}
	
}
