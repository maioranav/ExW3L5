package model;

import javax.persistence.Entity;
import javax.persistence.NamedQuery;

import controller.Main;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@NamedQuery(name = "Libro.findAll", query = "SELECT l FROM Libro l")
public class Libro extends Pubblicazione {

	private String author;

	private String genre;
	
	public Libro() {
		
	}

	public Libro(long isbn, String title, int year, int pages, String author2, String genre2) {
		this.setIsbn(isbn);
		this.setTitle(title);
		this.setYear(year);
		this.setPages(pages);
		this.setAuthor(author2);
		this.setGenre(genre2);
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	@Override
	public String toString() {
		return "Libro [isbn=" + this.getIsbn() + ", title=" + this.getTitle() + ", year=" + this.getYear() + ", pages=" + this.getPages() + ", author=" + author + ", genre=" + genre + "]";
	}
	
	
    public static Libro newBookByScan() {
        System.out.println(">> Inserisci l'ISBN del libro");
        long isbn = Main.scan.nextLong();
        Main.scan.nextLine();
        System.out.println(">> Inserisci titolo del libro");
        String title = Main.scan.nextLine();
        System.out.println(">> Inserisci anno di pubblicazione");
        int year = Main.scan.nextInt();
        System.out.println(">> Inserisci il numero di pagine");
        int pages = Main.scan.nextInt();
        Main.scan.nextLine();
        System.out.println(">> Inserisci il nome dell'autore");
        String author = Main.scan.nextLine();
        System.out.println(">> Inserisci il genere del libro");
        String genre = Main.scan.nextLine();
        System.out.println("Grazie, libro aggiunto alla biblioteca!");
        while (true) {
            try {
                return new Libro(isbn, title, year, pages, author, genre);
            } catch (Exception e) {
                e.printStackTrace();
                System.out.println(">> Inserisci l'ISBN del libro");
                isbn = Main.scan.nextLong();
            }
        }
    }
	

}
