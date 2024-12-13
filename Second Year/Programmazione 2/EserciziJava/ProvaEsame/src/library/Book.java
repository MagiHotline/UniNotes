package library;

/**
 * Un libro.
 */
public abstract class Book implements Comparable<Book> {

	private final String title;
	private final String author;
	private final int year;
	private final Genre genre;

	/**
	 * Crea un libro.
	 * 
	 * @param title il titolo del libro
	 * @param author l'autore del libro
	 * @param year l'anno di pubblicazione del libro
	 * @param genre il genere del libro
	 * @throws IllegalArgumentException se qualche parametro e' null
	 */
	protected Book(String title, String author, int year, Genre genre) throws IllegalArgumentException {
		this.title = title;
		this.author = author;
		this.year = year;
		this.genre = genre;
	}

	/**
	 * Restituisce il titolo del libro.
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * Restituisce l'autore del libro.
	 */
	public String getAuthor() {
		return author;
	}

	/**
	 * Restituisce il genere del libro.
	 */
	public Genre getGenre() {
		return genre;
	}

	/**
	 * Restituisce l'anno di pubblicazione del libro.
	 */
	public int getYear() {
		return year;
	}

	/**
	 * Ritorna il titolo fra doppi apici seguito dall'autore e poi
	 * (fra parentesi) anno di pubblicazione e genere.
	 */
	@Override
	public String toString() {
		return "\"" + title + "\" by " + author + " (" + year + ", " + genre + ")";
	}

	/**
	 * Due libri sono equals se hanno stesso titolo, autore e anno di pubblicazione.
	 * Il genre non viene preso in considerazione.
	 */
	@Override
	public boolean equals(Object other) {
		return other instanceof Book && title.equals(((Book) other).title) && author.equals(((Book) other).author)
				&& year == ((Book) other).year;
	}

	@Override
	public int hashCode() {
		return title.hashCode() + author.hashCode() + year;
	}

	/**
	 * Due libri sono ordinati per titolo; a parità di titolo, sono ordinati per autore;
	 * a parità anche di autore, sono ordinati per anno di pubblicazione.
	 */
	@Override
	public int compareTo(Book other) {
		if(title.compareTo(other.title) == 0) {
			if(author.compareTo(other.author) == 0) {
				return year - other.year;
			}
			return author.compareTo(other.author);
		}

		return title.compareTo(other.title);
	}
}