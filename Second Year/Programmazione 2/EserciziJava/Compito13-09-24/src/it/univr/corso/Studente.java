package it.univr.corso;

import java.util.Scanner;
import java.time.*;

/**
 * Uno studente, che si puo' iscrivere agli esami di un corso di laurea.
 */
public class Studente implements Comparable<Studente> {

	private final String nome;
	private final String cognome;
	private final int matricola;
	private final int annoDiImmatricolazione;

	/**
	 * Crea uno studente con il nome, cognome, matricola e anno di immatricolazione indicati.
	 * 
	 * @throws StudenteIllegaleException se l'anno di immatricolazione è nel futuro
	 *                                   o se la matricola è negativa
	 */
	public Studente(String nome, String cognome, int matricola, int annoDiImmatricolazione) throws StudenteIllegaleException {

		int now = Year.now().getValue();
		if(annoDiImmatricolazione > now || matricola < 0) {
			throw new StudenteIllegaleException("Studente Illegale, riprova");
		}

		this.nome = nome;
		this.cognome = cognome;
		this.matricola = matricola;
		this.annoDiImmatricolazione = annoDiImmatricolazione;
	}

	/**
	 * Legge da tastiera i dati di uno studente, lo crea e lo restituisce.
	 * Già fatto, non modificate.
	 * 
	 * @throws StudenteIllegaleException se i dati letti sono illegali
	 */
	public static Studente leggiDaTastiera(Scanner keyboard) throws StudenteIllegaleException {
		System.out.print("Nome: ");
		String nome = keyboard.nextLine();
		System.out.print("Cognome: ");
		String cognome = keyboard.nextLine();
		System.out.print("Matricola: ");
		int matricola = keyboard.nextInt(); keyboard.nextLine();
		System.out.print("Anno di immatricolazione: ");
		int annoDiImmatricolazione = keyboard.nextInt(); keyboard.nextLine();

		return new Studente(nome, cognome, matricola, annoDiImmatricolazione);
	}

	/**
	 * Due studenti sono uguali se e solo se hanno la stessa matricola.
	 */
	@Override
	public boolean equals(Object other) {
		return other instanceof Studente && this.matricola == ((Studente) other).matricola;
	}

	/**
	 * Deve essere non banale e compatibile con equals.
	 */
	@Override
	public int hashCode() {
		return matricola;
	}

	/**
	 * Determina chi viene prima (per matricola) tra this e other.
	 */
	@Override
	public int compareTo(Studente other) {
		return this.matricola - other.matricola;
	}

	@Override
	public String toString() {
		// restituisce una stringa del tipo "34555 Giulio Andreotti immatricolato nel 2017"

		return matricola + " " + nome + " " + cognome + " immatricolato nel " + annoDiImmatricolazione;
	}

	/**
	 * Determina se questo studente e' fuori corso rispetto al corso di laurea indicato:
	 * ovvero se si e' immatricolato prima della durata del corso di laurea.
	 */
	public boolean fuoriCorso(Corso corso) {
		// 2023 -- Informatica 3 anni
		int now = Year.now().getValue();

		return (annoDiImmatricolazione + corso.getDurata()) < now;
	}

	// aggiungete i metodi accessori pubblici getAnnoDiImmatricolazione() e getMatricola()


	public int getAnnoDiImmatricolazione() {
		return annoDiImmatricolazione;
	}

	public int getMatricola() {
		return matricola;
	}
}
