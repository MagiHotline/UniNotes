package it.univr.corso;

import java.time.Year;

/**
 * Uno studente lavoratore è identico a uno studente ma finisce fuori corso
 * nel doppio di anni rispetto a uno studente non lavoratore.
 */
public class StudenteLavoratore extends Studente {

	public StudenteLavoratore(String nome, String cognome, int matricola, int annoDiImmatricolazione) throws StudenteIllegaleException {
		super(nome, cognome, matricola, annoDiImmatricolazione);
	}

	// forse dovete ridefinire qualcosa?
	public boolean fuoriCorso(Corso corso) {

		int now = Year.now().getValue();

		return this.getAnnoDiImmatricolazione() + (corso.getDurata()*2) < now;
	}
}
