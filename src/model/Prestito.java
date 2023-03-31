package model;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name = "prestiti")
@NamedQuery(name = "Prestito.findAll", query = "SELECT pr FROM Prestito pr")
public class Prestito implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable = false)
	private Utente utente;
	@Column(nullable = false)
	private Pubblicazione pubblicazione;
	
	@Column(nullable = false)
	private LocalDate dataprestito;
	
	@Column(nullable = false)
	private LocalDate restprevista;
	
	private LocalDate resteffettiva;
	
	
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
	
	
	
}
