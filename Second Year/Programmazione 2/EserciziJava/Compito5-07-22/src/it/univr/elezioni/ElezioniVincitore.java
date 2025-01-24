package it.univr.elezioni;

/**
 * Un tipo di elezione la cui stampa aggiunge l'indicazione
 * di quale partito ha vinto le elezioni.
 */
public class ElezioniVincitore extends Elezioni {

	@Override
	public String toString() {

		// Determina il vincitore
		Partito vincitore = null;
		int maxVoti = 0;
		boolean parita = false;

		for (VotiPerPartito entry : this) {
			if(entry.voti > maxVoti) {
				maxVoti = entry.voti;
				vincitore = entry.partito;
			}
		}

		return super.toString() + "Vince " + vincitore;
	}
}