package testIntegrazione1;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import it.unisa.bean.CarrelloBean;
import it.unisa.model.CarrelloManagerDM;
import it.unisa.bean.ProdottoInMagazzinoBean;
import junit.framework.TestCase;

public class TestDoInsertProdotti extends TestCase {
	
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
	public void testDoInsertProdotti() throws Exception{
		CarrelloBean carrello = new CarrelloBean();
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
		
		
		CarrelloBean result = crm.doRetrieveByKey("CMMGTN80A01C361B");
		
		
		assertEquals(carrello.getElement(prodottoMagazzino), result.getElement(prodottoMagazzino));
	}

}
