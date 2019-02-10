package test;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import it.unisa.model.ProdottoBean;
import it.unisa.model.ProdottoInMagazzinoBean;
import it.unisa.model.ProdottoManagerDM;
import junit.framework.TestCase;

public class TestProdotto extends TestCase {
	
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
	
	@Test
	public void testDoDelete() throws Exception {
		ProdottoInMagazzinoBean prodottoMagazzino = new ProdottoInMagazzinoBean();
		prodottoMagazzino.setCosto(10);
		prodottoMagazzino.setDescrizione("ciao sono arduino");
		prodottoMagazzino.setIdProdotto(2);
		prodottoMagazzino.setMarca("arduino");
		prodottoMagazzino.setTipo("arduino");
		prodottoMagazzino.setNome("arduino UNO");
		prodottoMagazzino.setImmagine("arduino.jpg");
		prodottoMagazzino.setQuantitaInMagazzino(2);
		prodottoMagazzino.setQuantitaNelCarrello(1);
		prodottoMagazzino.setPromo(false);
		
		boolean result = pdm.doDelete(prodottoMagazzino.getIdProdotto());
		
		assertEquals(true,result);
	} 
	
	@Test
	public void testDoSaveInMagazzino() throws Exception {
		pdm.doSave(prodottoMagazzino);
		pdm.doSaveInMagazzino(prodottoMagazzino, false, prodottoMagazzino.getQuantitaInMagazzino());
		
		ProdottoInMagazzinoBean result = (ProdottoInMagazzinoBean) pdm.doRetrieveByKey(prodottoMagazzino.getIdProdotto(), "prodottoinmagazzino");

		
		assertEquals(prodottoMagazzino.getIdProdotto(), result.getIdProdotto());
		assertEquals(prodottoMagazzino.getTipo(), result.getTipo());
		assertEquals(prodottoMagazzino.getCosto(), result.getCosto());
		assertEquals(prodottoMagazzino.getDescrizione(), result.getDescrizione());
		assertEquals(prodottoMagazzino.getMarca(), result.getMarca());
		assertEquals(prodottoMagazzino.getImmagine(), result.getImmagine());
		assertEquals(prodottoMagazzino.getNome(), result.getNome());	
	}
	
	@Test
	public void testdoUpdateQuantitaInMagazzino() throws Exception {
		pdm.doUpdateQuantitaInMagazzino(prodottoMagazzino.getIdProdotto(), 4);
		
		ProdottoInMagazzinoBean result = (ProdottoInMagazzinoBean) pdm.doRetrieveByKey(prodottoMagazzino.getIdProdotto(), "prodottoinmagazzino");
		
		assertEquals(4,result.getQuantitaInMagazzino());
	}
	
	@Test
	public void testdoUpdateQuantitaNelCarrello() throws Exception {
		
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
		
		
		pdm.doUpdateQuantitaNelCarrello(prodottoMagazzino.getIdProdotto(), 3);
		
		ProdottoInMagazzinoBean result = (ProdottoInMagazzinoBean) pdm.doRetrieveByKey(prodottoMagazzino.getIdProdotto(), "prodottoinmagazzino");
		
		assertEquals(3,result.getQuantitaNelCarrello());
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
	
	@Test
	public void testDoRetrieveAll() throws Exception {
		ArrayList<ProdottoInMagazzinoBean> coll =  (ArrayList<ProdottoInMagazzinoBean>) pdm.doRetrieveAll();
		
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
		
		

		assertEquals(coll.get(2).getIdProdotto(),prodottoMagazzino.getIdProdotto());
		
	}
	
	@Test
	public void testDoRetrieveCategoria() throws Exception{
		ArrayList<ProdottoBean> coll =  (ArrayList<ProdottoBean>) pdm.doRetrieveCategoria("arduino");
		
		ProdottoBean prodottoMagazzino = new ProdottoBean();

		prodottoMagazzino.setCosto(10);
		prodottoMagazzino.setDescrizione("ciao sono arduino");
		prodottoMagazzino.setIdProdotto(4);
		prodottoMagazzino.setMarca("arduino");
		prodottoMagazzino.setTipo("arduino");
		prodottoMagazzino.setNome("arduino UNO");
		prodottoMagazzino.setImmagine("arduino.jpg");
	
		
		assertEquals(coll.get(2).getCosto(),prodottoMagazzino.getCosto());
		assertEquals(coll.get(2).getDescrizione(),prodottoMagazzino.getDescrizione());
		assertEquals(coll.get(2).getIdProdotto(),prodottoMagazzino.getIdProdotto());
		assertEquals(coll.get(2).getMarca(),prodottoMagazzino.getMarca());
		assertEquals(coll.get(2).getTipo(),prodottoMagazzino.getTipo());
		assertEquals(coll.get(2).getNome(),prodottoMagazzino.getNome());
		assertEquals(coll.get(2).getImmagine(),prodottoMagazzino.getImmagine());

	}
	
	@Test
	public void testDoUpdatePrezzo() throws Exception{
		ProdottoInMagazzinoBean prodottoMagazzino = new ProdottoInMagazzinoBean();
		prodottoMagazzino.setCosto(10);
		prodottoMagazzino.setDescrizione("ciao sono arduino");
		prodottoMagazzino.setIdProdotto(3);
		prodottoMagazzino.setMarca("arduino");
		prodottoMagazzino.setTipo("arduino");
		prodottoMagazzino.setNome("arduino UNO");
		prodottoMagazzino.setImmagine("arduino.jpg");
		prodottoMagazzino.setQuantitaInMagazzino(2);
		prodottoMagazzino.setQuantitaNelCarrello(1);
		prodottoMagazzino.setPromo(false);
		
		pdm.doUpdatePrezzo(prodottoMagazzino.getIdProdotto(), 20);
		
		ProdottoInMagazzinoBean result = (ProdottoInMagazzinoBean) pdm.doRetrieveByKey(prodottoMagazzino.getIdProdotto(), "prodottoinmagazzino");
		
		assertEquals(20.0, result.getCosto());
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
