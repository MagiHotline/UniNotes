package it.univr.notes.univr.notes;

import java.util.Iterator;
import java.util.NoSuchElementException;

// implementazione di una scala, cioè di una canzone
// che parte da una nota e continua con le note
// successivamente più alte, per un totale di 12 note
public class Scale extends AbstractSong {
	// SI CHIEDE DI RISOLVERE QUESTO ESERCIZIO SENZA AGGIUNGERE ALTRI CAMPI A QUESTA CLASSE!
	private final Note start;
	public final static int LENGTH = 12; // la lunghezza della scala: 12 note
	// SI CHIEDE DI RISOLVERE QUESTO ESERCIZIO SENZA AGGIUNGERE ALTRI CAMPI A QUESTA CLASSE!
	
	// Costruisce una scala, cioè una canzone fatta dalle note
	//
	// start
	// start.shift(1)
	// start.shift(2)
	// start.shift(3)
	// ...
	// start.shift(11)
	//
	// lancia una IllegalNoteException
	// se una delle note della scala è fuori dai limiti 0...MAX_SEMITONE
	public Scale(Note start) throws IllegalNoteException {
		if(start.shift(11).getSemitone() > Note.MAX_SEMITONE) {
			throw new IllegalNoteException();
		}

		this.start = start;
	}

	public Iterator<Note> iterator() {
		return new Iterator<>() {
			private int index = 0;
			private Note current = start;

			@Override
			public boolean hasNext() {
				return index < LENGTH;
			}

			@Override
			public Note next() {
				Note result = current;
				current = current.shift(1);
				index++;
				return result;
			}
		};
	}

	public Song shift(int howManySemitones) throws IllegalNoteException {
		return new Scale(start.shift(howManySemitones));
	}
}