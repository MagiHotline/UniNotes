package it.univr.elezioni;


import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;
import java.util.List;
import java.util.ArrayList;

/**
 * Un oggetto di questa classe permette di registrare voti per dei partiti.
 * Iterando su questo oggetto, si ottengono delle coppie partito/voti ottenuti,
 * messe in ordine crescente per partito.
 */
public class Elezioni implements Iterable<VotiPerPartito> {

	private final Map<Partito, Integer> voti = new TreeMap<>();

	public final void vota(Partito partito) {
		if(partito == null) {
			throw new IllegalArgumentException("Partito nullo o vuoto");
		} else {
			// Aumento di uno il voto del partito
			voti.put(partito, voti.getOrDefault(partito, 0) + 1);
		}
	}

	/**
	 * Ritorna una stringa che descrive l'elezione, del tipo:

1        Bassotti:  4467 voti (28.11%)
2         Caotico:  4679 voti (29.45%)
3          Felice:  1591 voti (10.01%)
4        Floreale:  3950 voti (24.86%)
5      Pensionati:  1202 voti (7.56%)

	   I partiti sono riportati in ordine crescente, con a sinistra un indice
	   crescente del partito (da 1 in su). Dopo il nome del partito viene riportato
	   il numero dei voti ottenuti e la percentuale ottenuta fra tutti i voti espressi.
	 */
	@Override
	public String toString() {
		StringBuilder ret = new StringBuilder();

		int totale = voti.values().stream().mapToInt(Integer::intValue).sum();

		int index = 1;
		for (Map.Entry<Partito, Integer> entry : voti.entrySet()) {
			Partito partito = entry.getKey();
			int numVoto = entry.getValue();
			double perc = (numVoto*100.0) / totale;
			ret.append(String.format("%d %12s: %5d voti (%.2f%%)%n",
					index++, partito.toString(), numVoto, perc));
		}

		return ret.toString();
	}

    /**
     * Iterando su questo oggetto, si ottengono delle coppie partito/voti ottenuti,
     * messe in ordine crescente per partito.
     */
	@Override
	public final Iterator<VotiPerPartito> iterator() {
		List<VotiPerPartito> listaVoti = new ArrayList<>();
		for (Map.Entry<Partito, Integer> entry : voti.entrySet()) {
			listaVoti.add(new VotiPerPartito(entry.getKey(), entry.getValue()));
		}

		return listaVoti.iterator();
	}
}
