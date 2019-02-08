package it.unisa.model;

import java.io.Serializable;
import java.sql.Date;

public class UserBean implements Serializable{
private String username;
private String cf;
private String nome;
private String cognome;
private String email;
private String password;
private String ruolo;
private String indirizzo;

	public UserBean() {
		username="";
		cf="";
		nome="";
		cognome="";
		email="";
		password="";
		indirizzo = "";
		setRuolo("");
	}
	public String getIndirizzo() {
		return indirizzo;
	}
	public void setIndirizzo(String indirizzo) {
		this.indirizzo = indirizzo;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getCf() {
		return cf;
	}
	public void setCf(String cf) {
		this.cf = cf;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCognome() {
		return cognome;
	}
	public void setCognome(String cognome) {
		this.cognome = cognome;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	public boolean equals(Object obj) {
		if (this.getUsername() == ((UserBean)obj).getUsername())
			return true;
		return false;
	}
	public String getRuolo() {
		return ruolo;
	}
	public void setRuolo(String ruolo) {
		this.ruolo = ruolo;
	}
	

}
