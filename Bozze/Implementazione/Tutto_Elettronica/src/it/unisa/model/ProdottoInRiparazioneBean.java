package it.unisa.model;

import java.io.Serializable;
import java.util.Date;

public class ProdottoInRiparazioneBean extends ProdottoBean{

	private int idPrenotazione;
	private Date dataIncontro;
	private String codiceCliente;
	private String statoRiparazione;
	private String descrizioneProblema;
	private Date dataFineLavoro;
	

	public ProdottoInRiparazioneBean() {
		super();
		idPrenotazione = 0;
		dataIncontro = null;
		codiceCliente = "";
		statoRiparazione = "";
		descrizioneProblema = "";
		dataFineLavoro = null;
	}
	
	public Date getDataFineLavoro() {
		return dataFineLavoro;
	}

	public void setDataFineLavoro(Date dataFineLavoro) {
		this.dataFineLavoro = dataFineLavoro;
	}

	public int getIdPrenotazione() {
		return idPrenotazione;
	}

	public void setIdPrenotazione(int idPrenotazione) {
		this.idPrenotazione = idPrenotazione;
	}

	public Date getDataIncontro() {
		return dataIncontro;
	}

	public void setDataIncontro(Date dataIncontro) {
		this.dataIncontro = dataIncontro;
	}

	public String getCodiceCliente() {
		return codiceCliente;
	}

	public void setCodiceCliente(String codiceCliente) {
		this.codiceCliente = codiceCliente;
	}

	public String getStatoRiparazione() {
		return statoRiparazione;
	}

	public void setStatoRiparazione(String statoRiparazione) {
		this.statoRiparazione = statoRiparazione;
	}

	public String getDescrizioneProblema() {
		return descrizioneProblema;
	}

	public void setDescrizioneProblema(String descrizioneProblema) {
		this.descrizioneProblema = descrizioneProblema;
	}

}
