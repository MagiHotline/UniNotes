package it.univr.dadi;

import java.util.random.*;

/**
 * Un dado ha un numero prefissato di facce e può essere lanciato.
 */
public abstract class Dado {

    /**
     * Il numero di facce del dado. Si noti che e' pubblico.
     */
    public final int facce;

    /**
     * Costruisce un dado con un numero prefissato di facce.
     * Lancia IllegalArgumentException il numero di facce non e' positivo.
     */
    protected Dado(int facce) {
        if(facce < 0) throw new IllegalArgumentException();
        this.facce = facce;
    }

    /**
     * Restituisce un numero casuale fra 1 (incluso) e il numero di facce del dado (incluso).
     */
    public final int lancio() {
        return (int)(Math.random() * facce) + 1;
    }
}