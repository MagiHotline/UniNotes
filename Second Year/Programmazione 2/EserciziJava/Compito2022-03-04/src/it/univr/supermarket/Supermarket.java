package it.univr.supermarket;

import java.util.List;
import java.util.TreeSet;

/**
 * Un supermercato, cioe' un contenitore di prodotti.
 */
public class Supermarket {

    private TreeSet<Product> supermercato = new TreeSet<>();

    /**
     * Aggiunge i prodotti indicati a questo supermercato.
     * Se ci fossero ripetizioni (cioe' due prodotti equals), li aggiunge una volta sola.
     */
    public void add(Product... products) {
        supermercato.addAll(List.of(products));
    }

    /**
     * Restituisce una stringa che descrive questo supermercato a questo istante (System.currentTimeMillis).
     * Si comporta quindi come il toString(when) che c'e' subito sotto, ma usa il tempo corrente
     * come momento in cui creare la descrizione del supermercato.
     */
    @Override
    public String toString() {
        return toString(System.currentTimeMillis());
    }

    /**
     * Restituisce una stringa che descrive questo supermercato al momento indicato.
     * Sara' una sequenza di prodotti, in ordine crescente rispetto al loro
     * compareTo(), ognuno descritto come negli esempi che seguono:
     *
     * se il prodotto e' gia' scaduto al tempo when: "pane: expired"
     * altrimenti, se il prodotto scade nelle 24 ore successive a when: "mozzarella: 2.70 euros (special offer)"
     * altrimenti "uova: 2.50 euros"
     *
     * Si noti che nel secondo caso il prezzo riportato e' quello al momento when, quindi scontanto.
     *
     * @param when il momento in cui si vuole creare la descrizione del supermercato
     * @return la stringa
     */
    public String toString(long when) {
        String ret = "";
        for(Product product : supermercato) {
            if(product.hasExpired(when)) {
                ret += product + ": expired\n";
            } else if(product.expiresInSubsequent24Hours(when)) {
                ret += String.format("%s: %.2f euros (special offer)\n", product, product.getPrice(when));
            } else {
                ret += String.format("%s: %.2f euros\n", product, product.getPrice());
            }
        }


        return ret;
    }
}