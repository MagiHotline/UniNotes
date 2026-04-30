package it.univr.notes.univr.notes;

// una nota che si stampa secondo la modalità italiana
public class ItalianNote extends AbstractNote {

	/**
	 * Costruisce la nota.
	 * 
	 * @param semitone il semitono della nota
	 * @throws IllegalNoteException se il semitono è fuoti dai limiti 0...MAX_SEMITONE
	 */
	public ItalianNote(int semitone) throws IllegalNoteException {
		super(semitone);
	}

	public Note shift(int howManySemitones) throws IllegalNoteException {
		return new ItalianNote(getSemitone() + howManySemitones);
	}

	// le 12 note italiane
	private final static String[] NOTES = {
		"do", "do#", "re", "re#", "mi", "fa", "fa#", "sol", "sol#", "la", "la#", "si"
	};

	// restituisce la rappresentazione di questa nota italiana, per esempio 2.fa#
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
