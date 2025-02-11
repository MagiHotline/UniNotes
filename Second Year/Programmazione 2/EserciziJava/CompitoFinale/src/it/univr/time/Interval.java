package it.univr.time;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

// un intervallo di tempo, da un istante iniziale
// in avanti, per un certo numero di secondi
public class Interval implements Iterable<Time> {
	// completare
	private final Time start;
	private final int howManySeconds;
	private final List<Time> instanti;

	// crea un internal da start (incluso) a start + howManySeconds (escluso)
	// lancia IllegalArgumentException se howManySeconds è negativo
	public Interval(Time start, int howManySeconds) {
		if(howManySeconds < 0) throw new IllegalArgumentException();
		this.start = start;
		this.howManySeconds = howManySeconds;
		instanti = new ArrayList<>();
	}

	// l'iteratore deve generare gli istanti
	// da start (incluso) a start + howManySeconds (escluso)
	@Override
	public Iterator<Time> iterator() {
		Time nextTime = start;
		for(int i = 0; i < howManySeconds; i++) {
			instanti.add(nextTime);
			nextTime = nextTime.next();
		}

		return instanti.iterator();
	}
}