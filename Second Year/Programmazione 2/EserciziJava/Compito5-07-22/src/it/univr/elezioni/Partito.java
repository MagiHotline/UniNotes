package it.univr.elezioni;

/**
 * Un partito ha un nome, passato al momento della costruzione.
 */
public class Partito implements Comparable<Partito> {

	private final String nome;

	public Partito(String nome) {
		this.nome = nome;
	}

	/**
	 * Determina chi fra this e other viene prima in ordine alfabetico per nome.
	 */
	@Override
	public int compareTo(Partito other) {
		return this.nome.compareTo(other.nome);
	}

	// due partiti sono uguali se e solo se hanno nome uguale
	@Override
	public boolean equals(Object other) {
		return this.nome.equals(((Partito) other).nome);
	}

	@Override
	public int hashCode() {
		return this.nome.hashCode();
	}

	/**
	 * Restituisce il nome del partito.
	 */
	@Override
	public String toString() {
		return this.nome;
	}
}