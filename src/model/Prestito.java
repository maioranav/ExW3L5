package model;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import controller.Main;

@Entity
@Table(name = "prestiti")
@NamedQuery(name = "Prestito.findAll", query = "SELECT pr FROM Prestito pr")
public class Prestito implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne
	private Utente utente;

	@ManyToOne
	private Pubblicazione pubblicazione;

	@Column(nullable = false)
	private LocalDate dataprestito;

	@Column(nullable = false)
	private LocalDate restprevista;

	private LocalDate resteffettiva;
	
	public Prestito() {
		
	}

	public Prestito(Pubblicazione pubb, Utente user, LocalDate dataprestito2) {
		this.setPubblicazione(pubb);
		this.setUtente(user);
		this.setDataprestito(dataprestito2);
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Utente getUtente() {
		return utente;
	}

	public void setUtente(Utente utente) {
		this.utente = utente;
	}

	public Pubblicazione getPubblicazione() {
		return pubblicazione;
	}

	public void setPubblicazione(Pubblicazione pubblicazione) {
		this.pubblicazione = pubblicazione;
	}

	public LocalDate getDataprestito() {
		return dataprestito;
	}

	public void setDataprestito(LocalDate dataprestito) {
		this.dataprestito = dataprestito;
		this.setRestprevista(dataprestito.plusDays(30));
	}

	public LocalDate getRestprevista() {
		return restprevista;
	}

	public void setRestprevista(LocalDate restprevista) {
		this.restprevista = restprevista;
	}

	public LocalDate getResteffettiva() {
		return resteffettiva;
	}

	public void setResteffettiva(LocalDate resteffettiva) {
		this.resteffettiva = resteffettiva;
	}

	@Override
	public String toString() {
		return "Prestito [id=" + id + ", utente=" + utente + ", pubblicazione=" + pubblicazione + ", dataprestito="
				+ dataprestito + ", restprevista=" + restprevista + ", resteffettiva=" + resteffettiva + "]";
	}

	public static Prestito newPrestito() {
		System.out.println(">> Inserisci l'ISBN da prestare");
		long isbn = Main.scan.nextLong();
		Pubblicazione pubb = Main.getByIsbn(isbn);
		Main.scan.nextLine();
		System.out.println(">> Inserisci il numero di tessera");
		Long tessera = Main.scan.nextLong();
		Utente user = Main.getUserByTessera(tessera);
		System.out.println(">> Inserisci anno prestito");
		int year = Main.scan.nextInt();
		System.out.println(">> Inserisci mese (MM) prestito");
		int month = Main.scan.nextInt();
		System.out.println(">> Inserisci giorno prestito");
		int day = Main.scan.nextInt();
		Main.scan.nextLine();
		LocalDate dataprestito = LocalDate.of(year, month, day);
		while (true) {
			try {
				return new Prestito(pubb, user, dataprestito);
			} catch (Exception e) {
				e.printStackTrace();
				System.out.println(">> Inserisci il numero di tessera");
				tessera = Main.scan.nextLong();
			}
		}
	}

}
