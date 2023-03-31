package model;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import controller.Main;

@Entity

@Table(name = "utenti")
@NamedQuery(name = "Utente.findAll", query = "SELECT u FROM Utente u")
public class Utente implements Serializable {

	@Id
	@Column(nullable = false, unique = true)
	private Long tessera;

	@Column(nullable = false)
	private String name;

	@Column(nullable = false)
	private String surname;

	@Column(nullable = false)
	private LocalDate datadinascita;

	public Utente() {

	}

	public Utente(long tessera2, String nome, String surname2, LocalDate of) {
		this.setTessera(tessera2);
		this.setName(nome);
		this.setSurname(surname2);
		this.setDatadinascita(of);
	}

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

	@Override
	public String toString() {
		return "Utente [tessera=" + tessera + ", name=" + name + ", surname=" + surname + ", datadinascita="
				+ datadinascita + "]";
	}

	public static Utente newUtente() {
		System.out.println(">> Inserisci il numero di Tessera");
		long tessera = Main.scan.nextLong();
		Main.scan.nextLine();
		System.out.println(">> Inserisci il nome");
		String nome = Main.scan.nextLine();
		System.out.println(">> Inserisci il cognome");
		String surname = Main.scan.nextLine();
		System.out.println(">> Inserisci anno di nascita");
		int year = Main.scan.nextInt();
		System.out.println(">> Inserisci mese di nascita (MM)");
		int month = Main.scan.nextInt();
		System.out.println(">> Inserisci giorno di nascita");
		int day = Main.scan.nextInt();
		Main.scan.nextLine();
		while (true) {
			try {
				return new Utente(tessera, nome, surname, LocalDate.of(year, month, day));
			} catch (Exception e) {
				e.printStackTrace();
				System.out.println(">> Inserisci il numero di tessera");
				tessera = Main.scan.nextLong();
			}
		}
	}

}
