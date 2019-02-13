package testProdotto;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import it.unisa.bean.ProdottoInMagazzinoBean;
import it.unisa.model.ProdottoManagerDM;
import junit.framework.TestCase;

public class TestDoRetrieveByKey extends TestCase{

	ProdottoInMagazzinoBean prodottoMagazzino;
	ProdottoManagerDM pdm;
	ProdottoInMagazzinoBean prodottoMagazzino1;
	
	@Before
	@Override
	protected void setUp() throws Exception {
		// TODO Auto-generated method stub
		super.setUp();
		
		pdm = new ProdottoManagerDM();
		prodottoMagazzino = new ProdottoInMagazzinoBean();
		prodottoMagazzino1 = new ProdottoInMagazzinoBean();
		prodottoMagazzino.setCosto(10);
		prodottoMagazzino.setDescrizione("ciao sono arduino");
		prodottoMagazzino.setIdProdotto(1);
		prodottoMagazzino.setMarca("arduino");
		prodottoMagazzino.setTipo("arduino");
		prodottoMagazzino.setNome("arduino UNO");
		prodottoMagazzino.setImmagine("arduino.jpg");
		prodottoMagazzino.setQuantitaInMagazzino(2);
		prodottoMagazzino.setQuantitaNelCarrello(1);
		prodottoMagazzino.setPromo(false);
		
		prodottoMagazzino1.setCosto(10);
		prodottoMagazzino1.setDescrizione("ciao sono arduino");
		prodottoMagazzino1.setIdProdotto(2);
		prodottoMagazzino1.setMarca("arduino");
		prodottoMagazzino1.setTipo("arduino");
		prodottoMagazzino1.setNome("arduino UNO");
		prodottoMagazzino1.setImmagine("arduino.jpg");
		prodottoMagazzino1.setQuantitaInMagazzino(2);
		prodottoMagazzino1.setQuantitaNelCarrello(1);
		prodottoMagazzino1.setPromo(false);
	}
	
	@After
	@Override
	protected void tearDown() throws Exception {
		// TODO Auto-generated method stub
		super.tearDown();

	}
	
	@Test
	public void testDoRetrieveByKey() throws Exception {
		
		
		ProdottoInMagazzinoBean result = (ProdottoInMagazzinoBean) pdm.doRetrieveByKey(prodottoMagazzino.getIdProdotto(), "prodottoinmagazzino");

		
		assertEquals(prodottoMagazzino.getIdProdotto(), result.getIdProdotto());
		assertEquals(prodottoMagazzino.getTipo(), result.getTipo());
		assertEquals(prodottoMagazzino.getCosto(), result.getCosto());
		assertEquals(prodottoMagazzino.getDescrizione(), result.getDescrizione());
		assertEquals(prodottoMagazzino.getMarca(), result.getMarca());
		assertEquals(prodottoMagazzino.getImmagine(), result.getImmagine());
		assertEquals(prodottoMagazzino.getNome(), result.getNome());		
	} 
	
}
