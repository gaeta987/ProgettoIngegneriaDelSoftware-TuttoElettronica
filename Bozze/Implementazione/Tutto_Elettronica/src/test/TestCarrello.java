package test;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import it.unisa.model.Carrello;
import it.unisa.model.CarrelloManagerDM;
import it.unisa.model.ProdottoInMagazzinoBean;
import it.unisa.model.ProdottoManagerDM;
import junit.framework.TestCase;

public class TestCarrello extends TestCase {
		
		CarrelloManagerDM crm;
		
		@Before
		@Override
		protected void setUp() throws Exception {
			// TODO Auto-generated method stub
			super.setUp();
			
			crm = new CarrelloManagerDM();
		}
		
		@After
		@Override
		protected void tearDown() throws Exception {
			// TODO Auto-generated method stub
			super.tearDown();

		}
	
	@Test
	public void testDoRetrieveByKey() throws Exception{
		Carrello carrello = new Carrello();
		
		carrello.setId(1);
		
		Carrello result = crm.doRetrieveByKey("CMMGTN80A01C361Z");
		
		assertEquals(carrello.getId(), result.getId());
		
	}
	
	@Test
	public void testDoInsertProdotti() throws Exception{
		Carrello carrello = new Carrello();
		ProdottoInMagazzinoBean prodottoMagazzino = new ProdottoInMagazzinoBean();
		prodottoMagazzino.setCosto(10);
		prodottoMagazzino.setDescrizione("ciao sono arduino");
		prodottoMagazzino.setIdProdotto(5);
		prodottoMagazzino.setMarca("arduino");
		prodottoMagazzino.setTipo("arduino");
		prodottoMagazzino.setNome("arduino UNO");
		prodottoMagazzino.setImmagine("arduino.jpg");
		prodottoMagazzino.setQuantitaInMagazzino(10);
		prodottoMagazzino.setQuantitaNelCarrello(0);
		prodottoMagazzino.setPromo(false);
		
		carrello.addElement(prodottoMagazzino);
		carrello.setCodiceFiscaleCliente("CMMGTN80A01C361B");
		
		crm.doInsertProdotti(carrello);
		
		
		Carrello result = crm.doRetrieveByKey("CMMGTN80A01C361B");
		
		
		assertEquals(carrello.getElement(prodottoMagazzino), result.getElement(prodottoMagazzino));
	}

	@Test
	public void testDoDeleteProdotti() throws Exception{
		Carrello carrello = new Carrello();
		
		carrello = crm.doRetrieveByKey("CMMGTN80A01C361X");
		
		assertEquals(true, crm.doDeleteProdotti(carrello));
	}

	
	@Test
	public void testDoPrenota() throws Exception{
		Carrello carrello = new Carrello();
		
		carrello = crm.doRetrieveByKey("CMMGTN80A01C361Z");
		
		assertEquals(true, crm.doPrenota("CMMGTN80A01C361Z", (ProdottoInMagazzinoBean)carrello.getList().get(0)));
		
	}

}
