package it.unisa.model;

import java.io.Serializable;

public class ProdottoBean implements Serializable{
private int idProdotto;
private String nome;
private String tipo;
private String marca;
private double costo;
private int quantita;
private String immagine;
private String descrizione;


	public ProdottoBean() {
		descrizione="";
		tipo="";
		immagine="";
		costo=0;
		nome="";
		idProdotto = 0;
		marca = "";
		quantita = 0;
	}
	public int getIdProdotto() {
		return idProdotto;
	}
	public void setIdProdotto(int idProdotto) {
		this.idProdotto = idProdotto;
	}
	public String getMarca() {
		return marca;
	}
	public void setMarca(String marca) {
		this.marca = marca;
	}
	public int getQuantita() {
		return quantita;
	}
	public void setQuantita(int quantita) {
		this.quantita = quantita;
	}
	public String getImmagine() {
		return immagine;
	}
	public void setImmagine(String immagine) {
		this.immagine = immagine;
	}
	public String getDescrizione() {
		return descrizione;
	}
	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	
	public double getCosto() {
		return costo;
	}
	public void setCosto(double costo) {
		this.costo = costo;
	}
	
	public boolean equals(Object obj) {
		if(this.idProdotto==((ProdottoBean)obj).idProdotto)
			return true;
		return false;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}

}
