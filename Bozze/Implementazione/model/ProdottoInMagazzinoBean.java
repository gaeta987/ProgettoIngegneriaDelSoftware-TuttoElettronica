package it.unisa.model;

import java.io.Serializable;

public class ProdottoInMagazzinoBean extends ProdottoBean{

	private boolean promo;
	
	public ProdottoInMagazzinoBean() {
		super();
		promo = false;
	}

	public boolean isPromo() {
		return promo;
	}

	public void setPromo(boolean promo) {
		this.promo = promo;
	}
	

}
