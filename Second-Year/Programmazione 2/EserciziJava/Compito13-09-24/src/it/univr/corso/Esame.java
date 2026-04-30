package it.univr.corso;

import java.util.ArrayList;
import java.util.SortedSet;
import java.util.TreeSet;
import java.util.function.Consumer;
import java.util.function.Predicate;

/**
 * Un esame di un corso di laurea, con il nome dell'esame e il corso
 * di laurea a cui appartiene.
 */
public class Esame {

	private final String nome;
	private final Corso corso;
	private TreeSet<Studente> studenti;

	/**
	 * Crea un esame con il nome indicato, per il corso indicato, inizialmente senza iscritti.
	 */
	public Esame(String nome, Corso corso) {
		this.nome = nome;
		this.corso = corso;
		studenti = new TreeSet<>();
	}

	/**
	 * Iscrive lo studente indicato a questo esame.
	 * 
	 * @throws StudenteIllegaleException se ci fosse già uno studente
	 *                                   iscritto a questo esame con la stessa matricola
	 */
	public void iscrivi(Studente studente) throws StudenteIllegaleException {
		if (studenti.contains(studente)) { throw new StudenteIllegaleException("Studente già iscritto"); }

		studenti.add(studente);
	}

	@Override
	public String toString() {
		String res = "Esame di " + nome + " del corso di " + corso.getNome() + "\n";
		// restituisce la stringa ottenuta concatenando tutti gli iscritti all'esame
		// in ordine crescente per matricola; all'inizio riporta nome dell'esame e corso;
		// si veda l'esempio nel testo del compito
		for(Studente studente : studenti) {
			res += studente.toString() + "\n";
		}

		return res;
	}

	/**
	 * Esegue l'azione indicata per ogni studente iscritto che soddisfa
	 * la condizione indicata.
	 */
	public void perOgniIscritto(Predicate<Studente> condizione, Consumer<Studente> azione) {
		for (Studente studente : studenti) {
			if (condizione.test(studente)) {
				azione.accept(studente);
			}
		}
	}
}
