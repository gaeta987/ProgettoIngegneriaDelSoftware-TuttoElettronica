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

public class TestDoRetrieveAllRiparazioni extends TestCase {

	ProdottoManagerDM pmd;
	ProdottoBean prodotto;
	RiparazioneManagerDM rmd;
	java.sql.Date sqlData;
	java.sql.Date sqlData3;
	String dataInizio;
	
	@Before
	@Override
	protected void setUp() throws Exception {
		pmd =  new ProdottoManagerDM();
		prodotto =  new ProdottoBean();
		rmd =  new RiparazioneManagerDM();
		
		dataInizio = "2019-01-11";
		
		SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd");
		java.util.Date date = null;
			date = sdf1.parse(dataInizio);
			// TODO Auto-generated catch block

		sqlData = new java.sql.Date(date.getTime());
	}
	
	@After
	@Override
	protected void tearDown() throws Exception {
		// TODO Auto-generated method stub
		super.tearDown();
	}
	
	@Test
	public void testDoRetrieveAllRiparazioni() throws SQLException, ParseException {
		
		String dataFine = "2019-02-08";
		
		SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd");
		java.util.Date date = null;
			date = sdf1.parse(dataFine);
			// TODO Auto-generated catch block

		Date sqlData3 = new java.sql.Date(date.getTime());
		
		ArrayList<ProdottoInRiparazioneBean> collection = (ArrayList<ProdottoInRiparazioneBean>) rmd.doRetrieveAllRiparazioni();
		
		ProdottoInRiparazioneBean prodottoRip =  new ProdottoInRiparazioneBean();
		
		prodottoRip.setIdPrenotazione(1);
		prodottoRip.setIdProdotto(4);
		prodottoRip.setDataIncontro(sqlData);
		prodottoRip.setCodiceCliente("CMMGTN80A01C361Z");
		prodottoRip.setStatoRiparazione("riparato");
		prodottoRip.setDescrizioneProblema("ciao sono arduino");
		prodottoRip.setDataFineLavoro(sqlData3);
		prodottoRip.setTipo("arduino");
		
		assertEquals(collection.get(0).getIdPrenotazione(),prodottoRip.getIdPrenotazione());
		assertEquals(collection.get(0).getIdProdotto(),prodottoRip.getIdProdotto());
		assertEquals(collection.get(0).getDataIncontro(),prodottoRip.getDataIncontro());
		assertEquals(collection.get(0).getCodiceCliente(),prodottoRip.getCodiceCliente());
		assertEquals(collection.get(0).getStatoRiparazione(),prodottoRip.getStatoRiparazione());
		assertEquals(collection.get(0).getDescrizioneProblema(),prodottoRip.getDescrizioneProblema());
		assertEquals(collection.get(0).getDataFineLavoro(),prodottoRip.getDataFineLavoro());
		
	}
}
