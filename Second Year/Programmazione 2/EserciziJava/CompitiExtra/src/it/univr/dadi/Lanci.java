package it.univr.dadi;


import java.util.*;

/**
 * Una classe che rappresenta l'esecuzione di piu' lanci con dei dadi.
 * Permette di vedere i risultati ottenuti e la frequenza dei numeri ottenuti.
 */
public class Lanci {

    private final ArrayList<Integer> results = new ArrayList<>();
    private final ArrayList<Dado> dadi = new ArrayList<>();
    private final Set<Integer> seen = new HashSet<>();

    /**
     * Costruisce un'esecuzione di quanti lanci con i dadi indicati.
     * Questo costruttore deve eseguire i lanci richiesti con i dadi forniti
     * e si salvera' le informazioni necessarie a implementare i metodi
     * della classe.
     *
     * @param quanti il numero di lanci da eseguire
     * @param dadi i dadi da lanciare. Per ogni lancio, il risultato e'
     *             la somma dei risultati di ciascun dado
     * @throws IllegalArgumentException se quanti non e' positivo oppure
     *         se non vengono forniti dadi da lanciare
     */
    public Lanci(int quanti, Dado... dadi) {
        if(quanti < 0 || dadi.length == 0) throw new IllegalArgumentException();
        this.dadi.addAll(List.of(dadi));

        int sum;
        for(int i = 0; i < quanti; i++) {
            sum = 0;
            for(Dado dado : this.dadi) {
                sum += dado.lancio();
            }
            results.add(sum);
            seen.add(sum);
        }

    }

    /**
     * Restituisce la sequenza dei risultati ottenuti dal costruttore lanciando i dadi.
     * Sara' una stringa fatta da una sequenza, fra parentesi quadre, di numeri separati da virgola.
     */
    @Override
    public final String toString() {
         return results.toString();
    }

    /**
     * Restituisce una rappresentazione a istogramma delle frequenze dei
     * numeri ottenuti dal costruttore lanciando i dadi. Per ogni numero
     * ottenuto, questi istogramma rappresentano quante volte quel numero e' stato
     * ottenuto. Gli istogrammi sono fatti da una sequenza di asterischi lunga
     * in modo proporzionale alla frequenza, seguita dalla frequenza tra parentesi
     * tonde. Si vedano gli esempi nel testo del compito.
     */
    public final String frequenze() {
        String ris = "";
        long counter = 0;
        double freq = 0;

        for(Integer i : seen) {

            counter = results.stream().filter(res -> Objects.equals(res, i)).count();
            freq = ((double) counter / results.size());

            freq *= 100;

            ris += String.format("%s (%.1f%%)\n", barra(i, freq), freq);
        }

        return ris;
    }

    /**
     * Restituisce una barra di linghezza proporzianale
     * alla frequenza indicata con cui si e' ottenuto il risultato "i" lanciando i dadi.
     * Si trattera' di una sequenza di asterischi. Per esempio, se il numero 4
     * fosse uscito nel 15.3% dei casi, allora questo metodo verra' chiamato con i = 4
     * e frequenza = 15.3 e dovra' ritornare 15 asterischi.
     */
    protected String barra(int i, double frequenza) {
        String ris = i + ": ";
        for(int j = 0; j < frequenza; j++) {
            ris += "*";
        }

        return ris;
    }
}