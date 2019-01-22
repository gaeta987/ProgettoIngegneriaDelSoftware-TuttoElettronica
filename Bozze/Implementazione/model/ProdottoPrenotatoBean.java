package it.unisa.model;

import java.io.Serializable;
import java.util.Date;

public class ProdottoPrenotatoBean extends ProdottoBean{

	private int idPrenotazioneProdotto;
	private String codiceCliente;
	private double prezzo;
	private Date dataPrenotazione;
	private int quantitaPrenotata;

	public ProdottoPrenotatoBean() {
		super();
		idPrenotazioneProdotto = 0;
		codiceCliente = "";
		prezzo = 0;
		dataPrenotazione = null;
		quantitaPrenotata = 0;
	}

	public int getQuantitaPrenotata() {
		return quantitaPrenotata;
	}

	public void setQuantitaPrenotata(int quantitaPrenotata) {
		this.quantitaPrenotata = quantitaPrenotata;
	}
	
	public int getIdPrenotazioneProdotto() {
		return idPrenotazioneProdotto;
	}

	public void setIdPrenotazioneProdotto(int idPrenotazioneProdotto) {
		this.idPrenotazioneProdotto = idPrenotazioneProdotto;
	}

	public String getCodiceCliente() {
		return codiceCliente;
	}

	public void setCodiceCliente(String codiceCliente) {
		this.codiceCliente = codiceCliente;
	}

	public double getPrezzo() {
		return prezzo;
	}

	public void setPrezzo(double prezzo) {
		this.prezzo = prezzo;
	}

	public Date getDataPrenotazione() {
		return dataPrenotazione;
	}

	public void setDataPrenotazione(Date dataPrenotazione) {
		this.dataPrenotazione = dataPrenotazione;
	}

}
