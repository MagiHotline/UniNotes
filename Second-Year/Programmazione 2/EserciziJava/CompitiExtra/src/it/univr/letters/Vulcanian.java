package it.univr.letters;

/**
 * Una sequenza vulcaniana di lettere, cioe'
 * un caso particolare di sequenza LowerCase che e' fatta da due parti:
 * la prima parte contiene vocali in ordine alfabetico;
 * la seconda parte contiene consonanti in ordine alfabetico.
 */
public class Vulcanian extends LowerCase {

	// AGGIUNGERE QUI CAMPI PRIVATI SE SERVISSERO

	/**
	 * Crea una sequenza vulcaniana di length lettere.
	 * 
	 * @param length la lunghezza della sequenza da creare
	 * @throws IllegalArgumentException se length e' negativo
	 */	
	public Vulcanian(int length) {
		super(randomVulcanian(length));
	}

	/**
	 * Genera una stringa vulcaniana casuale lunga length.
	 */
	private static String randomVulcanian(int length) {

		int numberOfVocals = random.nextInt(length + 1);

		String vulcanian = "";

		int i;
		char c;
		for(i = 0; i < numberOfVocals; i++) {
				c = "aeiou".charAt(random.nextInt(5));
				if(vulcanian.charAt(i-1) <= c || i == 0)
					vulcanian += c;
		}

		for(int j = i; j < length; j++) {
			c = "bcdfghjkmlnpqrstuvwxyz".charAt(random.nextInt(22));
			if(vulcanian.charAt(i-1) <= c || j == i)
				vulcanian += c;
		}


		return vulcanian;
	}

	/**
	 * Crea una sequenza vulcaniana fatta dai caratteri di s,
	 * identici, nello stesso ordine.
	 * 
	 * @param s la stringa che contiene i caratteri da inserire nella sequenza
	 * @throws IllegalArgumentException se i caratteri di s non formano
	 *                                  una sequenza vulcaniana
	 */
	public Vulcanian(String s) {
		super(s);
	}
}