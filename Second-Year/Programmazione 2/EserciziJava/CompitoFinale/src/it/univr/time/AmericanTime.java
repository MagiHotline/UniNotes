package it.univr.time;

public class AmericanTime extends AbstractTime {

	public AmericanTime(int secondsFromStartOfDay) {
		super(secondsFromStartOfDay);
	}

	public final Time next() {
		if(this.getSecondsFromStartOfDay() == 86399)
			return new AmericanTime(0);
		else
			return new AmericanTime(getSecondsFromStartOfDay() + 1);
	}

	// restituisce una stringa che rappresenta un Time all'americana (am/pm)
	public String toString() {
		// 3600 secondi in un ora e gestisco l'overflow
		int hours = (getSecondsFromStartOfDay() / 3600) % 24;
		// Prendo il resto delle ore e lo divido per il numero di minuti in un ora (60)
		int minutes = (getSecondsFromStartOfDay() % 3600) / 60;
		// Per i secondi devo vedere per il numero di secondi in un ora
		int seconds = (getSecondsFromStartOfDay() % 60);

		// Converto le ore italiane in ore americane, gestendo l'overflow
		int americanHours = hours % 12;
		americanHours = (americanHours == 0) ? americanHours = 12 : americanHours;
		String amPm = hours < 12 ? "am" : "pm"; //devo capire se siamo nella mattina o nel pomeriggio

		// Minuti e secondi non cambiano
		return String.format("%02d:%02d:%02d%s", americanHours, minutes, seconds, amPm);
	}
}