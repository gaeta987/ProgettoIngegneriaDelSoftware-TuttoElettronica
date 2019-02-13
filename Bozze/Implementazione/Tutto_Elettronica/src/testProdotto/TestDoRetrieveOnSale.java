package testProdotto;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import it.unisa.bean.ProdottoInMagazzinoBean;
import it.unisa.model.ProdottoManagerDM;
import junit.framework.TestCase;

public class TestDoRetrieveOnSale extends TestCase {

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
	public void testDoRetrieveOnSale() throws Exception {
		ArrayList<ProdottoInMagazzinoBean> coll =  (ArrayList<ProdottoInMagazzinoBean>) pdm.doRetrieveOnSale();
		
		ProdottoInMagazzinoBean prodottoMagazzino = new ProdottoInMagazzinoBean();

		prodottoMagazzino.setCosto(10);
		prodottoMagazzino.setDescrizione("ciao sono arduino");
		prodottoMagazzino.setIdProdotto(4);
		prodottoMagazzino.setMarca("arduino");
		prodottoMagazzino.setTipo("arduino");
		prodottoMagazzino.setNome("arduino UNO");
		prodottoMagazzino.setImmagine("arduino.jpg");
		prodottoMagazzino.setQuantitaInMagazzino(10);
		prodottoMagazzino.setQuantitaNelCarrello(0);
		prodottoMagazzino.setPromo(true);
		

		
		assertEquals(coll.get(2).getCosto(),prodottoMagazzino.getCosto());
		assertEquals(coll.get(2).getDescrizione(),prodottoMagazzino.getDescrizione());
		assertEquals(coll.get(2).getIdProdotto(),prodottoMagazzino.getIdProdotto());
		assertEquals(coll.get(2).getMarca(),prodottoMagazzino.getMarca());
		assertEquals(coll.get(2).getTipo(),prodottoMagazzino.getTipo());
		assertEquals(coll.get(2).getNome(),prodottoMagazzino.getNome());
		assertEquals(coll.get(2).getImmagine(),prodottoMagazzino.getImmagine());
		assertEquals(coll.get(2).getQuantitaInMagazzino(),prodottoMagazzino.getQuantitaInMagazzino());
		assertEquals(coll.get(2).getQuantitaNelCarrello(),prodottoMagazzino.getQuantitaNelCarrello());
		assertEquals(coll.get(2).isPromo(),true);
		
	} 
	
}
