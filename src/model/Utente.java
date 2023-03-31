package model;

import java.io.Serializable;
import java.time.LocalDate;

public class Utente implements Serializable {
	
	private Long tessera;
	private String name;
	private String surname;
	private LocalDate datadinascita;
	
	
	public Long getTessera() {
		return tessera;
	}
	public void setTessera(Long tessera) {
		this.tessera = tessera;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSurname() {
		return surname;
	}
	public void setSurname(String surname) {
		this.surname = surname;
	}
	public LocalDate getDatadinascita() {
		return datadinascita;
	}
	public void setDatadinascita(LocalDate datadinascita) {
		this.datadinascita = datadinascita;
	}
	
	
}
