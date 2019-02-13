package testProdotto;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import it.unisa.bean.ProdottoInMagazzinoBean;
import it.unisa.model.ProdottoManagerDM;
import junit.framework.TestCase;

public class TestDoUpdatePromoAdd extends TestCase {

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
		prodottoMagazzino = new ProdottoInMagazzinoBean();
		prodottoMagazzino1 = new ProdottoInMagazzinoBean();
	}
	
	@After
	@Override
	protected void tearDown() throws Exception {
		// TODO Auto-generated method stub
		super.tearDown();

	}
	
	@Test
	public void testDoUpdatePromoAdd() throws Exception{
		
		ProdottoInMagazzinoBean prodottoMagazzino = new ProdottoInMagazzinoBean();
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
		pdm.doUpdatePromo(prodottoMagazzino.getIdProdotto(), "add");
		
		ProdottoInMagazzinoBean result = (ProdottoInMagazzinoBean) pdm.doRetrieveByKey(prodottoMagazzino.getIdProdotto(), "prodottoinmagazzino");
		
		assertEquals(true,result.isPromo());
	}  
	
}
