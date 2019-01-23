package it.unisa.model;

import java.io.Serializable;
import java.util.Date;

public class ProdottoPrenotatoBean extends ProdottoBean{

	private int idPrenotazioneProdotto;
	private String codiceCliente;
	private Date dataPrenotazione;
	private int quantitaPrenotata;

	public ProdottoPrenotatoBean() {
		super();
		idPrenotazioneProdotto = 0;
		codiceCliente = "";
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

	public Date getDataPrenotazione() {
		return dataPrenotazione;
	}

	public void setDataPrenotazione(Date dataPrenotazione) {
		this.dataPrenotazione = dataPrenotazione;
	}

}
