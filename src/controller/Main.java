package controller;

import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceException;
import javax.persistence.Query;

import model.Pubblicazione;
import model.Utente;
import utils.JpaUtil;

public class Main {

	public static Scanner scan = new Scanner(System.in);

	static EntityManagerFactory emf = JpaUtil.getEntityManagerFactory();
	static EntityManager em = emf.createEntityManager();

	public static void main(String[] args) {
		System.out.println("Connection on");

		System.out.println("\n** BIBLIOTECA DI VINCENZO **");

		while (true) {
			try {
				Menu.startMenu();
			} catch (PersistenceException e) {
				e.printStackTrace();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

	}

	public static void addPubblication(Pubblicazione p) throws PersistenceException {
		em.getTransaction().begin();
		em.persist(p);
		em.getTransaction().commit();
		System.out.println("Pubblicazione aggiunta al DB");
	}

	@SuppressWarnings("unchecked")
	public static List<Pubblicazione> findAllPubbs() {
		Query q = em.createNamedQuery("Pubblicazione.findAll");
		return q.getResultList();
	}
	
	@SuppressWarnings("unchecked")
	public static List<Pubblicazione> findByYear(int year) {
		Query q = em.createNamedQuery("Pubblicazione.findByYear");
		q.setParameter("year", year);
		return q.getResultList();
	}
	
	@SuppressWarnings("unchecked")
	public static List<Pubblicazione> findByTitle(String title) {
		Query q = em.createNamedQuery("Pubblicazione.findByTitle");
		q.setParameter("title", title);
		return q.getResultList();
	}
	
	@SuppressWarnings("unchecked")
	public static List<Pubblicazione> findByAuthor(String author) {
		Query q = em.createNamedQuery("Pubblicazione.findByAuthor");
		q.setParameter("author", author);
		return q.getResultList();
	}

	public static Pubblicazione getByIsbn(Long isbn) throws PersistenceException {
		em.getTransaction().begin();
		Pubblicazione p = em.find(Pubblicazione.class, isbn);
		em.getTransaction().commit();
		return p;
	}

	public static void delete(Pubblicazione p) throws PersistenceException {
		em.getTransaction().begin();
		em.remove(p);
		em.getTransaction().commit();
		System.out.println("Pubblicazione eliminata");
	}
	
	@SuppressWarnings("unchecked")
	public static List<Utente> findAllUsers() {
		Query q = em.createNamedQuery("Utente.findAll");
		return q.getResultList();
	}
	
	public static void addUser(Utente u) throws PersistenceException {
		em.getTransaction().begin();
		em.persist(u);
		em.getTransaction().commit();
		System.out.println("Utente aggiunto al DB");
	}

}
