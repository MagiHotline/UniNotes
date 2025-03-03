package it.univr.notes.univr.notes;

// implementazione parziale di una canzone: solo il metodo toString()
public abstract class AbstractSong implements Song {

	public final String toString() {
		// completare concatenando il toString() delle note di questa canzone,
		// con uno spazio come separatore
		// SUGGERIMENTO: si ricordi che i Song sono iterabili
		String ret = "";

		for(Note n : this) {
			ret += n.toString() + " ";
		}

		return ret;
	}
}
