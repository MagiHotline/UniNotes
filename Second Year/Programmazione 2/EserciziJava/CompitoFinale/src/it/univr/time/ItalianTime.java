package it.univr.time;

public class ItalianTime extends AbstractTime {


	public ItalianTime(int secondsFromStartOfDay) {
		super(secondsFromStartOfDay);
	}

	public final Time next() {
		if(this.getSecondsFromStartOfDay() == 86399)
			return new ItalianTime(0);
		else
			return new ItalianTime(getSecondsFromStartOfDay() + 1);
	}

	// restituisce una stringa che rappresenta un Time all'italiana
	public String toString() {
		// Converto dai secondi totali nelle componenti separate
		// 3600 secondi in un ora e gestisco l'overflow
		int hours = (getSecondsFromStartOfDay() / 3600) % 24;
		// Prendo il resto delle ore e lo divido per il numero di minuti in un ora (60)
		int minutes = (getSecondsFromStartOfDay() % 3600) / 60;
		// Per i secondi devo vedere per il numero di secondi in un ora
		int seconds = (getSecondsFromStartOfDay() % 60);
		return String.format("%02d:%02d:%02d", hours, minutes, seconds);
	}
}