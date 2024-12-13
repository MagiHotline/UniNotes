package library;

/**
 * Un catalogo che stampa anche statistiche sui libri contenuti.
 */
public class CatalogWithStatistics extends Catalog {

	/**
	 * Costruisce un catalogo con statistiche. L'ordinamento sara' quello del
	 * compareTo definito in Book.
	 * 
	 * @param books i libri contenuti nel catalogo. Anche se ci fossero ripetizioni,
	 *              il catalogo dovra' contenere una sola istanza del libro ripetuto
	 */
	public CatalogWithStatistics(Book... books) {
		super(books);
	}

	/**
	 * Si comprta come il toString() di Catalog, ma alla fine aggiunge una riga del tipo:
	 * "This catalog contains paper books for a total of XXX pages and audiobooks for a total of YYY minutes"
	 */
	@Override
	public String toString() {

		int CountPages = 0;
		int CountMinutes = 0;
		for (Book book : this) {
			 if(book instanceof PaperBook) {
				 CountPages += ((PaperBook) book).getPages();
			 } else {
				 CountMinutes += ((AudioBook) book).getMinutes();
			 }
		}

		return super.toString() + "This catalog contains paper books for a total of " + CountPages + " spages " +
				"and audiobooks for a total of " + CountMinutes + " minutes";
	}
}