package library;

import java.util.Comparator;

public class Main {

	public static void main(String[] args) {
		Book jj = new PaperBook("The joy of Java", "John Stack", 2018, Genre.COMPUTING, 557);
		Book cr = new AudioBook("Cappuccetto rosso", "Charles Perrault", 1697, Genre.FICTION, 13);
		Book ps = new AudioBook("I promessi sposi", "Alessandro Manzoni", 1840, Genre.FICTION, 1223);
		Book ps2 = new PaperBook("I promessi sposi", "Alessandro Manzoni", 1840, Genre.FICTION, 622);
		Book gl = new PaperBook("Sentieri in Lessinia", "Giovanni Gamba", 2015, Genre.GUIDE, 233);
		Book sv = new PaperBook("Gli Scala di Verona", "Roberta Guidi", 2012, Genre.HISTORY, 380);
		Book sv2 = new PaperBook("Gli Scala di Verona", "Roberta Guidi", 2012, Genre.HISTORY, 380);

		System.out.println("Ordinamento naturale:");
		// TODO: crea e poi stampa un catalogo con statistiche che contiene jj, cr, ps, ps2, gl, sv, sv2, ordinato
		CatalogWithStatistics c1 = new CatalogWithStatistics(jj, cr, ps, ps2, gl, sv, sv2);
		System.out.println(c1);

		System.out.println("\nOrdinamento per autore:");

		class compareAuthor implements Comparator<Book> {

			@Override
			public int compare(Book o1, Book o2) {
				if(o1.getAuthor().compareTo(o2.getAuthor()) == 0) {
					return o1.compareTo(o2);
				}

				return o1.getAuthor().compareTo(o2.getAuthor());
			}
		}

		class compareYear implements Comparator<Book> {
			public int compare(Book o1, Book o2) {
				int diff =  o1.getYear() - o2.getYear();
				if(diff == 0) {
					return o1.compareTo(o2);
				} else {
					return diff;
				}
			}
		}

		compareAuthor compareAuth = new compareAuthor();
		compareYear compareYear = new compareYear();

		Catalog c2 = new Catalog(compareAuth, jj, cr, ps, ps2, gl, sv, sv2);
		System.out.println(c2);

		System.out.println("Ordinamento per anno di pubblicazione:");
		// TODO: crea e poi stampa un catalogo che contiene jj, cr, ps, ps2, gl, sv, sv2, ordinato
		// per anno e, a parita' di anno, secondo il compareTo fra i libri
		Catalog c3 = new Catalog(compareYear, gl, cr, ps, ps2, sv, sv2);
		System.out.println(c3);

		try {
			new PaperBook("Gli Scala di Verona", "Roberta Guidi", 2012, Genre.HISTORY, -380);
			System.out.println("legale");
		}
		catch (IllegalArgumentException e) {
			System.out.println("illegale");
		}

		try {
			new PaperBook("Gli Scala di Verona", null, 2012, Genre.HISTORY, 380);
			System.out.println("legale");
		}
		catch (IllegalArgumentException e) {
			System.out.println("illegale");
		}
	}
}
