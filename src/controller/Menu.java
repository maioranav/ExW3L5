package controller;

import java.util.List;

import javax.persistence.PersistenceException;

import model.Libro;
import model.Prestito;
import model.Pubblicazione;
import model.Rivista;
import model.Utente;

public class Menu {

	public static void startMenu() throws PersistenceException, Exception {
		
                System.out.println("=> SCEGLI COSA FARE:\n");
	            System.out.println("\t  1 - AGGIUNGI UNA PUBBLICAZIONE");
	            System.out.println("\t  2 - RIMUOVI UNA PUBBLICAZIONE TRAMITE IL SUO ISBN");
	            System.out.println("\t  3 - RICERCA PER ISBN");
	            System.out.println("\t  4 - RICERCA PER ANNO DI PUBBLICAZIONE");
	            System.out.println("\t  5 - RICERCA PER AUTORE");
	            System.out.println("\t  6 - RICERCA PER TITOLO");
	            System.out.println("\t  7 - MOSTRA TUTTO");
	            System.out.println("\t  8 - CREA UN NUOVO UTENTE");
	            System.out.println("\t  9 - ELENCA UTENTI");
	            System.out.println("\t 10 - CREA UN NUOVO PRESTITO");
	            System.out.println("\t 11 - CERCA PRESTITI IN CORSO PER TESSERA UTENTE");
	            System.out.println("\t 12 - ELENCA TUTTI I PRESTITI SCADUTI O NON RESTITUITI");
	            System.out.println("\t  0 - ESCI");

	            switch (Main.scan.nextInt()) {
	                case 1 -> {
	                    System.out.println("\n\tCosa vuoi aggiungere?\n\t 1-LIBRO\t2-RIVISTA");
	                    switch (Main.scan.nextInt()) {
	                        case 1 -> {
	                            System.out.println("=> INSERIAMO UN LIBRO");
	                            Main.scan.nextLine();
	                            Main.addPubblication(Libro.newBookByScan());
	                        }
	                        case 2 -> {
	                            System.out.println("=> INSERIAMO UNA RIVISTA");
	                            Main.scan.nextLine();
	                            Main.addPubblication(Rivista.newRivistaByScan());
	                        }
	                        default -> {
	                            System.out.println("Scelta non valida, riprova \n");
	                        }
	                    }
	                }
	                case 2 -> {
	                    System.out.print("\n\t >> INSERISCI ISBN DA ELIMINARE: ");
	                     Main.scan.nextLine();
	                   long isbn = Main.scan.nextLong();
	                   Pubblicazione pubb = Main.getByIsbn(isbn);
	                    if (pubb != null) {
	                       Main.delete(pubb);
	                    } else {
	                        System.out.println("\n\tNessuna corrispondenza soddisfa la ricerca.");
	                    }
	                }
	                case 3 -> {
	                    System.out.print("\n\t >> RICERCA PER ISBN: ");
	                     Main.scan.nextLine();
	                   long isbn = Main.scan.nextLong();
	                   Pubblicazione pubb = Main.getByIsbn(isbn);
	                    if (pubb != null) {
	                      System.out.println(pubb.toString());
	                    } else {
	                        System.out.println("\n\tNessuna corrispondenza soddisfa la ricerca.");
	                    }
	                    System.out.print("\n");
	                }
	                case 4 -> {
	                    System.out.print("\n\t >> RICERCA PER ANNO: ");
	                    int anno = Main.scan.nextInt();
	                    Main.scan.nextLine();
	                    System.out.print("\n");
	                    List<Pubblicazione> pubbs = Main.findByYear(anno);
	                    if (pubbs.size() > 0) {
	                    pubbs.forEach(a -> System.out.println(a.toString()));
	                    } else {
	                    	System.out.println("Non ci sono risultati per l'anno " + anno);
	                    }
	                    System.out.print("\n");
	                }
	                case 5 -> {
	                    System.out.print("\n\t >> RICERCA PER AUTORE: ");
	                    Main.scan.nextLine();
	                    String autore = Main.scan.nextLine();
	                    System.out.print("\n");
	                    List<Pubblicazione> pubbs = Main.findByAuthor(autore);
	                    if (pubbs.size() > 0) {
	                    pubbs.forEach(a -> System.out.println(a.toString()));
	                    } else {
	                    	System.out.println("Non ci sono risultati per l'autore " + autore);
	                    }
	                    System.out.print("\n");
	                }
	                case 6 -> {
	                    System.out.print("\n\t >> RICERCA PER TITOLO: ");
	                    Main.scan.nextLine();
	                    String titolo = Main.scan.nextLine();
	                    System.out.print("\n");
	                    List<Pubblicazione> pubbs = Main.findByTitle(titolo);
	                    if (pubbs.size() > 0) {
	                    pubbs.forEach(a -> System.out.println(a.toString()));
	                    } else {
	                    	System.out.println("Non ci sono risultati per " + titolo);
	                    }
	                    System.out.print("\n");
	                }
	                case 7 -> {
	                    System.out.println("\n\t >> MOSTRO TUTTI I LIBRI IN LIBRERIA");
	                    List<Pubblicazione> pubbs = Main.findAllPubbs();
	                    pubbs.forEach(a -> System.out.println(a));
	                    System.out.println("\t> Totale pubblicazioni diponibili: " + pubbs.size() + "\n");
	                }
	                case 8 -> {
	                	Main.scan.nextLine();
                        Main.addUser(Utente.newUtente());	                	
	                }
	                case 9 -> {
	                    System.out.println("\n\t >> MOSTRO TUTTI GLI UTENTI");
	                    List<Utente> users = Main.findAllUsers();
	                    users.forEach(a -> System.out.println(a));
	                    System.out.println("\t> Totale utenti registrati: " + users.size() + "\n");
	                }
	                case 10 -> {
	                	Main.scan.nextLine();
                        Main.addPrestito(Prestito.newPrestito());	                	
	                }
	                case 11 -> {
	                    System.out.print("\n\t >> ELENCO PRESTITI PER TESSERA: ");
	                     Main.scan.nextLine();
	                   long tessera = Main.scan.nextLong();
	                   List<Prestito> prest = Main.findByTessera(tessera);
	                    if (prest.size() > 0) {
	                    	prest.forEach(el -> System.out.println(el.toString()));
	                    } else {
	                        System.out.println("\n\tNessun prestito per questo numero di tessera.");
	                    }
	                    System.out.print("\n");
	                }
	                case 12 -> {
	                    System.out.println("\n\t >> MOSTRO I PRESTITI SCADUTI O NON RICONSEGNATI");
	                    List<Prestito> prestiti = Main.findScaduti();
	                    prestiti.forEach(pr -> System.out.println(pr));
	                    System.out.println("\t> Totale prestiti scaduti o da riconsegnare: " + prestiti.size() + "\n");
	                }
	                case 0 -> {
	                    System.out.println("\nQuesto programma è stato sviluppato da Vincenzo Maiorana");
	                    System.out.println("\nPer ulteriori informazioni visita https://www.vincenzomaiorana.it");
	                    System.out.println("\nArrivederci! <3");
	                    System.exit(1);
	                }
	                default -> System.out.println("Scelta non valida, riprova \n");
	            }


	        
		
	}
	
}
