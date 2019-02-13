package testIntegrazione;

import java.sql.SQLException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import it.unisa.bean.ProdottoBean;
import it.unisa.bean.ProdottoInRiparazioneBean;
import it.unisa.model.ProdottoManagerDM;
import it.unisa.model.RiparazioneManagerDM;
import junit.framework.TestCase;

public class TestDoUpdateStato extends TestCase {

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
	public void testDoUpdateStato() throws SQLException {
		
ProdottoInRiparazioneBean prodottoRiparazione =  new ProdottoInRiparazioneBean();
		
		prodottoRiparazione.setIdPrenotazione(1);
		prodotto.setIdProdotto(4);
		
		rmd.doUpdateStato("riparato", prodottoRiparazione.getIdPrenotazione());
		
		assertEquals("riparato" ,((ProdottoInRiparazioneBean) pmd.doRetrieveByKey(prodotto.getIdProdotto(), "prodottoinriparazione")).getStatoRiparazione());
		
	}
	
}
