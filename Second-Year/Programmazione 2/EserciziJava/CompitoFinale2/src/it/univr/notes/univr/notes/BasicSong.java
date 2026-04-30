package it.univr.notes.univr.notes;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

// implementazione concreta di una canzone, cioè di una sequenza di note
public class BasicSong extends AbstractSong {

	// le note di questa canzone
	private final List<Note> sequence;

	// costruisce una canzone fatta dalle note indicate
	public BasicSong(Note... notes) {
		sequence = Arrays.asList(notes);
	}

	public Iterator<Note> iterator() {
		return sequence.iterator();
	}

	public Song shift(int howManySemitones) throws IllegalNoteException {
		Note[] newSequence = new Note[sequence.size()];
		for(int i = 0; i < sequence.size(); i++) {
			newSequence[i] = sequence.get(i).shift(howManySemitones);
		}

		return new BasicSong(newSequence);
	}
}