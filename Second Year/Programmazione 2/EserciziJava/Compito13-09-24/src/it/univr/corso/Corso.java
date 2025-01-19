package it.univr.corso;

/**
 * Un corso di laurea (per esempio, informatica), con nome e durata in anni.
 */
public class Corso {

	private final String nome;
	private final int durata;

	public Corso(String nome, int durata) {
		this.nome = nome;
		this.durata = durata;
	}

	@Override
	public String toString() {
		return nome + " " + durata;
	}

	public String getNome() {
		return nome;
	}

	public int getDurata() {
		return durata;
	}
}