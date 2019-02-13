package it.unisa.bean;

import java.io.Serializable;

public class Recensionie implements Serializable {
	
	private int id;
	private String codiceCliente;
	private int codiceProdotto;
	private String testo;
	private int voto;

	public Recensionie() {
		id = 0;
		codiceCliente = "";
		codiceProdotto = 0;
		testo = "";
		voto = 0;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCodiceCliente() {
		return codiceCliente;
	}

	public void setCodiceCliente(String codiceCliente) {
		this.codiceCliente = codiceCliente;
	}

	public int getCodiceProdotto() {
		return codiceProdotto;
	}

	public void setCodiceProdotto(int codiceProdotto) {
		this.codiceProdotto = codiceProdotto;
	}

	public String getTesto() {
		return testo;
	}

	public void setTesto(String testo) {
		this.testo = testo;
	}

	public int getVoto() {
		return voto;
	}

	public void setVoto(int voto) {
		this.voto = voto;
	}
	

}
