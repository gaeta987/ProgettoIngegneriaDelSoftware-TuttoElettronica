package it.unisa.bean;

import java.io.Serializable;

public class ProdottoInMagazzinoBean extends ProdottoBean{

	private boolean promo;
	private int quantitaInMagazzino;
	private int quantitaNelCarrello;
	
	public ProdottoInMagazzinoBean() {
		super();
		promo = false;
		quantitaInMagazzino = 0;
		quantitaNelCarrello = 0;
	}

	public int getQuantitaNelCarrello() {
		return quantitaNelCarrello;
	}

	public void setQuantitaNelCarrello(int quantitaNelCarrello) {
		this.quantitaNelCarrello = quantitaNelCarrello;
	}

	public boolean isPromo() {
		return promo;
	}

	public void setPromo(boolean promo) {
		this.promo = promo;
	}

	public int getQuantitaInMagazzino() {
		return quantitaInMagazzino;
	}

	public void setQuantitaInMagazzino(int quantitaInMagazzino) {
		this.quantitaInMagazzino = quantitaInMagazzino;
	}
	
	public boolean equals(Object obj) {
		if (this.getIdProdotto() == ((ProdottoInMagazzinoBean)obj).getIdProdotto())
			return true;
		return false;
	}
	

}
