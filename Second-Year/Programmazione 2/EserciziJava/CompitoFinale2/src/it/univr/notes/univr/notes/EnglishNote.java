package it.univr.notes.univr.notes;

//una nota che si stampa secondo la modalità inglese
public class EnglishNote extends AbstractNote {

	/**
	 * Costruisce la nota.
	 * 
	 * @param semitone il semitono della nota
	 * @throws IllegalNoteException se il semitono è fuoti dai limiti 0...MAX_SEMITONE
	 */
	public EnglishNote(int semitone) throws IllegalNoteException {
		super(semitone);
	}

	public Note shift(int howManySemitones) throws IllegalNoteException {
		return new EnglishNote(getSemitone() + howManySemitones);
	}

	// le 12 note inglesi
	private final static String[] NOTES = {
		"C", "C#", "D", "D#", "E", "F", "F#", "G", "G#", "A", "A#", "B"
	};

	// restituisce la rappresentazione di questa nota inglese, per esempio 3.A
	public String toString() {

		String n = "";

		if(getSemitone() < 12) n = "1";
		else if(getSemitone() < 24) n = "2";
		else if(getSemitone() < 36) n = "3";
		else if(getSemitone() < 48) n = "4";
		else if(getSemitone() <= MAX_SEMITONE) n = "5";

		return n + "." + NOTES[getSemitone() % NOTES.length];
	}
}
