package it.univr.letters;

import java.util.Random;
import java.util.function.Consumer;

/**
 * Una sequenza di caratteri "minuscola", cioe' fatta da
 * lettere minuscole dell'alfabeto inglese.
 * Sono ammesse lettere ripetute.
 */
public class LowerCase implements Letters {

	protected final static Random random = new Random();
	private final String listofChars;
	// AGGIUNGERE QUI CAMPI PRIVATI SE SERVISSERO


	/**
	 * Crea una sequenza minuscola casuale.
	 * 
	 * @param length la lunghezza della sequenza da creare
	 * @throws IllegalArgumentException se length e' negativo
	 */
	public LowerCase(int length) {
		if(length < 0) throw new IllegalArgumentException();

		String listofChars = "";
		for(int i = 0; i < length; i++) {
			listofChars += (char) ('a' + random.nextInt('z' - 'a'));
		}

		this.listofChars = listofChars;
	}

	/**
	 * Crea una sequenza minuscola fatta dai caratteri di s, identici,
	 * nello stesso ordine.
	 * 
	 * @param s la stringa che contiene i caratteri da inserire nella sequenza
	 * @throws IllegalArgumentException se i caratteri di s non sono una sequenza minuscola
	 */
	public LowerCase(String s) {
		if(s.equals(s.toLowerCase())) throw new IllegalArgumentException();
		listofChars = s;
	}

	@Override
	public final int length() {
		return listofChars.length();
	}

	@Override
	public final String toString() {
		return listofChars;
	}

	@Override
	public final void forEach(Consumer<Character> what) {
		for(int i = 0; i < listofChars.length(); i++) {
			what.accept(listofChars.charAt(i));
		}
	}
}