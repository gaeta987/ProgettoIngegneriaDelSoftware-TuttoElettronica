package it.unisa.model;

import java.io.Serializable;
import java.util.*;

public class Cart<T> implements Serializable {
	
	private List<T> list;
	private int id;
	private String codiceFiscaleCliente;
	
	public Cart() {
		this.id = 0;
		codiceFiscaleCliente = "";
		list = new ArrayList<T>();
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCodiceFiscaleCliente() {
		return codiceFiscaleCliente;
	}

	public void setCodiceFiscaleCliente(String codiceFiscaleCliente) {
		this.codiceFiscaleCliente = codiceFiscaleCliente;
	}

	public void setList(List<T> list) {
		this.list = list;
	}

	public void addElement(T element) {
		list.add(element);
	}
	
	public void deleteElement(T element) {
		for(T elem : list) {
			if(elem.equals(element)) {
				list.remove(elem);
				break;
			}
		}
	}

	public List<T> getList(){
		return list;
	}
	
	
	
}
