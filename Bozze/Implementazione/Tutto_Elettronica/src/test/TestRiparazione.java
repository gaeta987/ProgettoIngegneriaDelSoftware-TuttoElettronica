package test;

import java.sql.Date;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import it.unisa.bean.ProdottoBean;
import it.unisa.bean.ProdottoInMagazzinoBean;
import it.unisa.bean.ProdottoInRiparazioneBean;
import it.unisa.model.ProdottoManagerDM;
import it.unisa.model.RiparazioneManagerDM;
import junit.framework.TestCase;

public class TestRiparazione extends TestCase {

	RiparazioneManagerDM rmd;
	ProdottoManagerDM pmd;
	ProdottoBean prodotto;
	java.sql.Date sqlData;
	java.sql.Date sqlData2;
	java.sql.Date sqlData3;
	String dataInizio;
	String data1 = "2019-01-30";
	String data2 = "2019-02-05";
	String data3 = "2019-02-25";
	
	@Before
	@Override
	protected void setUp() throws Exception {
		// TODO Auto-generated method stub
		super.setUp();
		
		prodotto = new ProdottoBean();
		pmd = new ProdottoManagerDM();
		rmd = new RiparazioneManagerDM();
		
		dataInizio = "2019-01-11";
		
		SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd");
		java.util.Date date = null;
			date = sdf1.parse(dataInizio);
			// TODO Auto-generated catch block

		sqlData = new java.sql.Date(date.getTime());
		
		prodotto.setCosto(10);
		prodotto.setDescrizione("ciao sono arduino");
		prodotto.setMarca("arduino");
		prodotto.setTipo("arduino");
		prodotto.setNome("arduino UNO");
		prodotto.setImmagine("arduino.jpg");
	}
	
	@After
	@Override
	protected void tearDown() throws Exception {
		// TODO Auto-generated method stub
		super.tearDown();
	}
	
	@Test
	public void testDoSaveRiparazione() throws SQLException {
		
		pmd.doSave(prodotto);
		prodotto.setIdProdotto(pmd.doRetrieveLastKey());
		rmd.doSaveRiparazione(prodotto, sqlData, "CMMGTN80A01C361Z");
		
		assertEquals("CMMGTN80A01C361Z", ((ProdottoInRiparazioneBean) pmd.doRetrieveByKey(prodotto.getIdProdotto(),"prodottoinriparazione")).getCodiceCliente());
		
	}
	
	public void testDoUpdateStato() throws SQLException {
		
		ProdottoInRiparazioneBean prodottoRiparazione =  new ProdottoInRiparazioneBean();
		
		prodottoRiparazione.setIdPrenotazione(1);
		prodotto.setIdProdotto(4);
		
		rmd.doUpdateStato("riparato", prodottoRiparazione.getIdPrenotazione());
		
		assertEquals("riparato" ,((ProdottoInRiparazioneBean) pmd.doRetrieveByKey(prodotto.getIdProdotto(), "prodottoinriparazione")).getStatoRiparazione());
	}
	
	public void testDoUpdateData() throws Exception {
		
		String dataFine = "2019-02-08";
		
		SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd");
		java.util.Date date = null;
			date = sdf1.parse(dataFine);
			// TODO Auto-generated catch block

		sqlData2 = new java.sql.Date(date.getTime());

		ProdottoInRiparazioneBean prodottoRiparazione =  new ProdottoInRiparazioneBean();
		prodottoRiparazione.setIdPrenotazione(2);
		prodotto.setIdProdotto(6);
		rmd.doUpdateData(sqlData2, prodottoRiparazione.getIdPrenotazione());
		
		assertEquals(sqlData2 ,((ProdottoInRiparazioneBean) pmd.doRetrieveByKey(prodotto.getIdProdotto(), "prodottoinriparazione")).getDataFineLavoro());
	}
	
	public void testDoRetriveAll() throws Exception {
		Date[] collection = (Date[]) rmd.doRetrieveAll();
	
		for(int i = 0; i < collection.length; i++) {
		assertEquals(data1, collection[0].toString());
		assertEquals(data2, collection[1].toString());
		assertEquals(data3, collection[2].toString());
		}
	}
	
	public void testDoRetriveAllRiparazioni() throws Exception {
		
		String dataFine = "2019-02-08";
		
		SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd");
		java.util.Date date = null;
			date = sdf1.parse(dataFine);
			// TODO Auto-generated catch block

		sqlData3 = new java.sql.Date(date.getTime());
		
		ArrayList<ProdottoInRiparazioneBean> collection = (ArrayList<ProdottoInRiparazioneBean>) rmd.doRetrieveAllRiparazioni();
		
		ProdottoInRiparazioneBean prodottoRip =  new ProdottoInRiparazioneBean();
		
		prodottoRip.setIdPrenotazione(1);
		prodottoRip.setIdProdotto(6);
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
