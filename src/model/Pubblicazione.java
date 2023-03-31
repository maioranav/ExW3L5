package model;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name = "pubblicazioni")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@NamedQuery(name = "Pubblicazione.findAll", query = "SELECT p FROM Pubblicazione p")
@NamedQuery(name = "Pubblicazione.findByYear", query = "SELECT p FROM Pubblicazione p WHERE p.year = :year ORDER BY p.year DESC")
@NamedQuery(name = "Pubblicazione.findByTitle", query = "SELECT p FROM Pubblicazione p WHERE LOWER(p.title) LIKE LOWER('%' || :title || '%')")
@NamedQuery(name = "Pubblicazione.findByAuthor", query = "SELECT p FROM Pubblicazione p WHERE LOWER(p.author) LIKE LOWER(:author)")

public abstract class Pubblicazione implements Serializable {
	
	@Id	
	@Column(nullable = false, unique = true)
	private Long isbn;
	
	@Column(nullable = false)
	private String title;
	
	@Column(nullable = false)
	private Integer year;
	
	@Column(nullable = false)
	private Integer pages;
	
	public Long getIsbn() {
		return isbn;
	}
	public void setIsbn(Long isbn) {
		this.isbn = isbn;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public Integer getYear() {
		return year;
	}
	public void setYear(Integer year) {
		this.year = year;
	}
	public Integer getPages() {
		return pages;
	}
	public void setPages(Integer pages) {
		this.pages = pages;
	}
	
	@Override
	public String toString() {
		return "Pubblicazione [isbn=" + isbn + ", title=" + title + ", year=" + year + ", pages=" + pages + "]";
	}
	
}
