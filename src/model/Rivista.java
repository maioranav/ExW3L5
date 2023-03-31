package model;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.NamedQuery;

import controller.Main;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@NamedQuery(name = "Rivista.findAll", query = "SELECT r FROM Rivista r")
public class Rivista extends Pubblicazione {

	
	  @Enumerated(EnumType.STRING)
	private PeriodType period;
	  
	  public Rivista() {
		  
	  }

	public Rivista(long isbn, String title, int year, int pages, PeriodType period2) {
		this.setIsbn(isbn);
		this.setTitle(title);
		this.setYear(year);
		this.setPages(pages);
		this.setPeriod(period2);
	}

	public PeriodType getPeriod() {
		return period;
	}

	public void setPeriod(PeriodType period) {
		this.period = period;
	}

	@Override
	public String toString() {
		return "Rivista [isbn=" + this.getIsbn() + ", title=" + this.getTitle() + ", year=" + this.getYear() + ", pages=" + this.getPages() + ", period=" + period + "]";
	}
	
	  public static Rivista newRivistaByScan() throws Exception {
	        System.out.println(">> Inserisci l'ISBN della rivista");
	        long isbn = Main.scan.nextLong();
	        Main.scan.nextLine();
	        System.out.println(">> Inserisci titolo della rivista");
	        String title = Main.scan.nextLine();
	        System.out.println(">> Inserisci anno di pubblicazione");
	        int year = Main.scan.nextInt();
	        System.out.println(">> Inserisci il numero di pagine");
	        int pages = Main.scan.nextInt();
	        System.out.println(">> Inserisci la frequenza di pubblicazione\n 1-SETTIMANALE\t2-MENSILE\t3-SEMESTRALE");
	        PeriodType period = null;
	        int periodscan = -1;
	        do {
	            periodscan = Main.scan.nextInt();
	            switch (periodscan) {
	                case 1:
	                    period = PeriodType.SETTIMANALE;
	                case 2:
	                    period = PeriodType.MENSILE;
	                case 3:
	                    period = PeriodType.SEMESTRALE;
	                case 0:
	                    System.out.println("Torno al menu principale");
	                    break;
	                default:
	                    System.out.println("Scelta non valida, riprova");

	            }
	            ;
	        } while (periodscan < 0 || periodscan > 3);

	        System.out.println("Grazie, rivista aggiunta alla biblioteca!");
	        while (true) {
	            try {
	                return new Rivista(isbn, title, year, pages, period);
	            } catch (Exception e) {
	                e.printStackTrace();
	                System.out.println(">> Inserisci l'ISBN del libro");
	                isbn = Main.scan.nextLong();
	            }
	        }
	    }

}
